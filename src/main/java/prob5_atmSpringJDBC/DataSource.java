package prob5_atmSpringJDBC;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
public class DataSource {

    private JdbcTemplate jdbcTemplate;

    public DataSource(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Reads the customer numbers and pins
     * and initializes the bank accounts.
     */
    public Map<Integer, Customer> readCustomers() throws SQLException {
        Map<Integer, Customer> customers = new HashMap<Integer, Customer>();

        DatabaseConnector database = DatabaseConnector.getInstance(jdbcTemplate);

        for (Customer c : database.getAllCustomer()) {
            customers.put(c.getCustomerNumber(), c);
        }

        return customers;
    }
}
