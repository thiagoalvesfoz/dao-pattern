package dao.impl;

import dao.UserDAO;
import infra.Database;

import java.sql.Connection;

public class DaoFactory {

    private static final Connection conn = Database.getConnection();

    public static UserDAO getUserDao() {
        return new UserMysql(conn); // <- aqui eu falo qual conexão a implementação usa
    }

}
