package dao.impl;

import dao.UserDAO;
import model.User;

import java.sql.*;
import java.util.List;

public class UserMysql implements UserDAO {

    private final Connection conn;

    public UserMysql(Connection conn) {
        this.conn = conn;
    }

    @Override
    public User save(User entity) {

        // Primeiro passo - organizar os dados que serão reutilizados, mais importantes
        String sql = "INSERT INTO users (fullname, phone, email) VALUES (?, ?, ?)";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // preparo a conexão e informo que quero que retorne a chave gerada pelo banco.
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // especifico quais valores o ponto de interrogação terá.
            stmt.setString(1, entity.getFullName());
            stmt.setString(2, entity.getPhone());
            stmt.setString(3, entity.getEmail());

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
    public List<User> findAll() {
        System.out.println("retornou uma lista");
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {
        System.out.println("usuário deletado");
    }
}
