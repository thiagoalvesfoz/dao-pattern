package dao.impl;

import dao.AddressDao;
import model.Address;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdressMysql implements AddressDao {

    private final Connection conn;

    public AdressMysql(Connection conn) {
        this.conn = conn;
    }


    @Override
    public Address save(Address entity) {
        // Primeiro passo - organizar os dados que serão reutilizados, mais importantes
        String sql = "INSERT INTO address (street, city, state, number) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // preparo a conexão e informo que quero que retorne a chave gerada pelo banco.
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // especifico quais valores o ponto de interrogação terá.
            stmt.setString(1, entity.getStreet());
            stmt.setString(2, entity.getCity());
            stmt.setString(3, entity.getState());
            stmt.setInt(4, entity.getNumber());


            // AÇÃO - executo a operação
            int affectedRows = stmt.executeUpdate();

            // lógica para verificar se foi salvo ou não
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            // proximo passo - recupero o id gerado pelo banco de dados.
            rs = stmt.getGeneratedKeys(); // preciso pegar a chave primaria que gerou.

            if (rs.next()) {
                entity.setId(rs.getInt(1));
                return entity;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

        return null;
    }

    @Override
    public List<Address> findAll() {
        return null;
    }

    @Override
    public Address findById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
