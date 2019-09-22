package prob5_atmSpringJDBC;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;
import java.util.List;

public class DatabaseConnector {
    // use singleton concept
    // static instance
    private static DatabaseConnector databaseConnectorInstance;
    private Connection conn;

    // for spring JDBC with annotation-DI
    private JdbcTemplate jdbcTemplate;

    public static DatabaseConnector getInstance(JdbcTemplate jdbcTemplate) {
        if (databaseConnectorInstance == null)
            databaseConnectorInstance = new DatabaseConnector(jdbcTemplate);

        return databaseConnectorInstance;
    }

    public DatabaseConnector(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        connect();
    }

    /**
     * use for connecting to database
     * and try to print all of data in this table
     */
    public void connect() {


        try {
            conn = jdbcTemplate.getDataSource().getConnection();
            if (conn != null) {
                System.out.println("Trying to connect the database.....");

                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Product name: " + dm.getDatabaseProductName());

                System.out.println("----- Data in Customer table -----");

                ResultSet resultSet = getResultSetByQuery(new String[]{}, "Customer");

                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    int pin = resultSet.getInt(2);
                    double currentBalance = resultSet.getDouble(3);

                    System.out.println(String.format("%d %d %f", id, pin, currentBalance));
                }

                System.out.println("---------------------------------");

                resultSet.close();
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    /**
     *
     * @param dataNames: an arrays of datas you need to query
     * @param tableName: a table name
     * @return result of query
     */
    public ResultSet getResultSetByQuery(String[] dataNames, String tableName) {
        String datas = "";
        if (dataNames.length > 0) {
            for (int index = 0 ; index < dataNames.length ; index++) {
                datas += dataNames[index];

                if (index != dataNames.length-1) datas += ", ";
            }
        } else datas = "*";

        // generate query string by parameter
        String query = String.format("SELECT %s FROM %s", datas, tableName);
        ResultSet resultSet = null;

        // trying to query and get resultSet
        try {
            Statement statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        return resultSet;
    }

    public List<Customer> getAllCustomer() {
        String query = "SELECT * FROM customer";
        List<Customer> customers = jdbcTemplate.query(query, new CustomerRowMapper());

        return customers;
    }

    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException sqlEx) {
            System.err.println("Can't disconnect. This connection has lost.");
        }
    }
}
