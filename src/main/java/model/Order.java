package model;

import java.time.OffsetDateTime;

public class Order {
    private Integer number;
    private OffsetDateTime ordered;
    private OffsetDateTime shipped;
    private Address shipTo;
    private Product product;
    private OrderStatus status;
    private User client;

    public Order() {
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public OffsetDateTime getOrdered() {
        return ordered;
    }

    public void setOrdered(OffsetDateTime ordered) {
        this.ordered = ordered;
    }

    public OffsetDateTime getShipped() {
        return shipped;
    }

    public void setShipped(OffsetDateTime shipped) {
        this.shipped = shipped;
    }

    public Address getShipTo() {
        return shipTo;
    }

    public void setShipTo(Address shipTo) {
        this.shipTo = shipTo;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "number=" + number +
                ", ordered=" + ordered +
                ", shipped=" + shipped +
                ", shipTo=" + shipTo +
                ", product=" + product +
                ", status=" + status.getValue() +
                ", client=" + client +
                '}';
    }
}
