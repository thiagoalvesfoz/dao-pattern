import model.*;

import java.time.OffsetDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello java");
//        Connection conn = Database.getConnection(); // funciona


        User client = new User();
        client.setId(1);
        client.setFullName("Thiago");
        client.setEmail("thiago@thiago.com");
        client.setPhone("45 9999-1234");

        Product product = new Product();
        product.setId(1);
        product.setName("Notebook");
        product.setPrice(2500.00);

        Address address = new Address();
        address.setId(1);
        address.setStreet("rua abelardo");
        address.setCity("São Francisco");
        address.setState("UFC");
        address.setNumber(70);

        Order order = new Order();
        order.setNumber(1234);
        order.setOrdered(OffsetDateTime.now());
        order.setShipped(OffsetDateTime.now());
        order.setShipTo(address);
        order.setClient(client);
        order.setProduct(product);
        order.setStatus(OrderStatus.HOLD);

        System.out.println(order); // modelagem funcional



    }
}
