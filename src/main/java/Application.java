import dao.UserDAO;
import dao.impl.DaoFactory;
import model.User;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        UserDAO userDAO = DaoFactory.getUserDao();

        // cenário 1 - onde tenho os dados do usuário
        User client = new User();
        client.setFullName("Thiago");
        client.setEmail("thiago@thiago.com");
        client.setPhone("45 9999-1234");

        System.out.println("unsaved ---> " + client);
        client = userDAO.save(client);
        System.out.println("saved   ---> " + client);

        // cenário 2 - buscar todos os usuários
        List<User> users = userDAO.findAll();
        for (User u : users) {
            System.out.println("---> " + u);
        }

        // cenário 3 - buscar um usuário
        User user = userDAO.findById(client.getId());
        System.out.println("findById ---> " + user);

        // cenário 4 - deletar um usuário
        userDAO.deleteById(user.getId());
        users = userDAO.findAll();
        for (User u : users) {
            System.out.println("---> " + u);
        }

    }
}
