package pe.isil.restaurant.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.isil.restaurant.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcProductRepository implements ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Product product) {
        final String sql = "insert into product(id, description, type, price) values (?,?,?,?)";
        jdbcTemplate.update(sql,product.getId(), product.getDescription(), product.getType(), product.getPrice());
    }

    @Override
    public void update(Product product) {

        final String sql = "update product set description = ?, type = ? , price = ?   where id = ?";
        jdbcTemplate.update(sql,product.getDescription(), product.getType(), product.getPrice(), product.getId());
    }

    @Override
    public void delete(Long aLong) {
        final String sql = "delete product where id = ?";
        jdbcTemplate.update(sql, aLong);
    }

    @Override
    public List<Product> findAll() {
        final String sql = "select * from product";
        return jdbcTemplate.query(sql,
                JdbcProductRepository::ProductRowMapper);
    }

    @Override
    public Product findById(Long aLong) {
        final String sql = "select * from product where id = ? ";

        return jdbcTemplate.queryForObject(sql,
                new Object[]{aLong},
                JdbcProductRepository::ProductRowMapper);
    }


    private static Product ProductRowMapper(ResultSet resultSet, int i) throws SQLException {
        Long rsId = resultSet.getLong("id");
        String description = resultSet.getString("description");
        String type = resultSet.getString("type");
        Float price = resultSet.getFloat("price");
        return new Product(rsId, description, type, price );
    }
}
