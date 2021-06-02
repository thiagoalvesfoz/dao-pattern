import dao.UserDAO;
import dao.impl.DaoFactory;
import model.User;

public class Application {
    public static void main(String[] args) {
        UserDAO userDAO = DaoFactory.getUserDao();

        // cenário - onde tenho os dados do usuário
        User client = new User();
        client.setFullName("Thiago");
        client.setEmail("thiago@thiago.com");
        client.setPhone("45 9999-1234");

        System.out.println(client);
        client = userDAO.save(client);
        System.out.println(client);
    }
}
