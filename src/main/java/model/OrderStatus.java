package model;

public enum OrderStatus {
    HOLD(1),
    DELIVERED(2),
    CANCELED(3);

    private final int value;

    OrderStatus(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

}
