package prob4_atmDatabaseWithAnnotationDI;

import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
public class DataSource {

    /**
     * Reads the customer numbers and pins
     * and initializes the bank accounts.
     */
    public Map<Integer, Customer> readCustomers() throws SQLException {
        Map<Integer, Customer> customers = new HashMap<Integer, Customer>();

        DatabaseConnector database = DatabaseConnector.getInstance();

        ResultSet resultSet = database.getResultSetByQuery(new String[]{"id", "pin", "balance"}, "Customer");
        while (resultSet.next()) {
            int number = resultSet.getInt("id");
            int pin = resultSet.getInt("pin");
            double currentBalance = resultSet.getDouble("balance");
            Customer c = new Customer(number, pin, currentBalance);
            customers.put(c.getCustomerNumber(), c);
        }

        resultSet.close();
        database.disconnect();
        return customers;
    }
}
