package org.example;

public class OrderPosition {
    private Long id;
    private Long orderId;
    private Double price;

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }

    public Long getOrderId() {
        return orderId;
    }
}
