package dao.impl;

import dao.AddressDao;
import dao.UserDAO;
import infra.Database;

import java.sql.Connection;

public class DaoFactory {

    private static final Connection conn = Database.getConnection();

    public static UserDAO getUserDao() {
        return new UserMysql(conn); // <- aqui eu falo qual conexão a implementação usa
    }

    public static AddressDao getAddresDao() {
        return new AdressMysql(conn);
    }
}
