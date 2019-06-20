package pe.isil.restaurant.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.isil.restaurant.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcCustomerRepository implements CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Customer customer) {
        final String sql = "insert into customer(id, name, lastname, address, phoneNumber, user, password) values (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,customer.getId(), customer.getName(), customer.getLastName(), customer.getAddress(), customer.getPhoneNumber(),customer.getUser(),customer.getPassword());
    }

    @Override
    public void update(Customer customer) {

        final String sql = "update customer set name = ?, lastname = ? , address = ? , phoneNumber = ? , user = ? , password = ?   where id = ?";
        jdbcTemplate.update(sql,customer.getName(), customer.getLastName(), customer.getAddress(), customer.getPhoneNumber(),customer.getUser(),customer.getPassword(),customer.getId());
    }

    @Override
    public void delete(Long aLong) {
        final String sql = "delete customer where id = ?";
        jdbcTemplate.update(sql, aLong);
    }

    @Override
    public List<Customer> findAll() {
        final String sql = "select * from customer";
        return jdbcTemplate.query(sql,
                JdbcCustomerRepository::CustomerRowMapper);
    }

    @Override
    public Customer findById(Long aLong) {
        final String sql = "select * from customer where id = ? ";

        return jdbcTemplate.queryForObject(sql,
                new Object[]{aLong},
                JdbcCustomerRepository::CustomerRowMapper);
    }


    private static Customer CustomerRowMapper(ResultSet resultSet, int i) throws SQLException {
        Long rsId = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String lastname = resultSet.getString("lastname");
        String address = resultSet.getString("address");
        String phoneNumber = resultSet.getString("phoneNumber");
        String user = resultSet.getString("user");
        String password = resultSet.getString("password");
        return new Customer(rsId, name, lastname, address, phoneNumber,user,password );
    }
}
