import dao.AddressDao;
import dao.impl.DaoFactory;
import model.Address;

public class AddressTest {
    public static void main(String[] args) {
        AddressDao addressDao = DaoFactory.getAddresDao();

        // cenarío 1 - salvar
        Address address = new Address();
        address.setStreet("Rua x");
        address.setCity("Cidade de Deus");
        address.setState("RJ");
        address.setNumber(70);

        addressDao.save(address);
    }
}
