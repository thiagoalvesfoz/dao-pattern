package dao.impl;

import dao.UserDAO;
import model.User;

import java.sql.*;
import java.util.ArrayList;
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

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();

        try {
            stmt = conn.prepareStatement(sql);

            //Executa a ação de consulta e atrubui o valor em um ResultSet
            rs = stmt.executeQuery();

            //Percorre a tabela user enquanto houver linhas
            while (rs.next()) {
                //Mapeamento da tabela user para o modelo de orientado a objetos
                User user = getInstanceUser(rs);

                //Adiciona o objeto instanciado na lista
                users.add(user);
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


        return users;
    }

    @Override
    public User findById(int id) {

        // Primeiro passo - organizar os dados que serão reutilizados
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM users WHERE id = ?";

        try {
            // preparo uma conexão
            stmt = conn.prepareStatement(sql);

            // injetando o valor do id no sql
            stmt.setInt(1, id);

            // AÇÃO - executar a consulta
            rs = stmt.executeQuery(); //devole a tabela com os registros (se encontrar)

            if (rs.next()) {
                return getInstanceUser(rs);
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
    public void deleteById(int id) {
        System.out.println("usuário deletado");

        PreparedStatement stmt = null;

        String sql = "DELETE FROM users WHERE id = ? ";

        try {
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("unable to delete user");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

    private User getInstanceUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setPhone(rs.getString("phone"));
        user.setEmail(rs.getString("email"));
        user.setFullName(rs.getString("fullname"));

        return user;
    }
}
