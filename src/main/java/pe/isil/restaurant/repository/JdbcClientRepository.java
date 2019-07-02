package pe.isil.restaurant.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.isil.restaurant.model.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcClientRepository  implements ClientRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Client client) {
        final String sql = "insert into client(idClient,razonSocial,tipoDoc,numDoc,Email) values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, client.getIdCliente(),client.getRazonSocial(),client.getTipoDoc(),client.getNumDoc(),client.getEmail());

    }

    @Override
    public void update(Client client) {
        final String sql = "update client set razonSocial=?, tipoDoc=?, numDoc=?,Email=?";
        jdbcTemplate.update(sql, client.getIdCliente(),client.getRazonSocial(),client.getTipoDoc(),client.getNumDoc(),client.getEmail());


    }

    @Override
    public void delete(Integer idClient) {
        final String sql ="delete client where idClient=?";
        jdbcTemplate.update(sql, idClient);

    }

    @Override
    public List<Client> findAll() {
        final String sql = "select * from client";
        return jdbcTemplate.query(sql, JdbcClientRepository::ClientRowMapper);
    }

    @Override
    public Client findById(Integer idClient) {
        final String sql="select * from client where idClient= ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{idClient},JdbcClientRepository::ClientRowMapper);
    }

    private  static Client ClientRowMapper(ResultSet resultSet, int i) throws SQLException{
        Integer rsidClient = resultSet.getInt("idClient");
        String razonSocial = resultSet.getString("razonSocial");
        String tipoDoc = resultSet.getString("tipoDoc");
        String numDoc = resultSet.getString("numDoc");
        String Email = resultSet.getString("Email");
        return new Client(rsidClient,razonSocial,tipoDoc,numDoc,Email);
    }
}
