import dao.UserDAO;
import dao.impl.DaoFactory;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        UserDAO userDAO = DaoFactory.getUserDao();

        // cenário - onde tenho os dados do usuário
        User client = new User();
        client.setFullName("Thiago");
        client.setEmail("thiago@thiago.com");
        client.setPhone("45 9999-1234");

        System.out.println(client);
        //client = userDAO.save(client);
        System.out.println(client);

        List<User> users = userDAO.findAll();
        for (User u : users) {
            System.out.println(u);
        }
    }
}
