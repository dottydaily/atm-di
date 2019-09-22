package prob5_atmSpringJDBC;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {
    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {

        Customer customer = new Customer(resultSet.getInt("id"),
                resultSet.getInt("pin"),
                resultSet.getDouble("balance"));

        return customer;
    }
}
