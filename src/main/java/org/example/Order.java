package org.example;

import org.springframework.context.annotation.Bean;

import java.util.List;

public class Order {

    private long id;
    private String comment;
    private List<OrderPosition> orderPositionList;

    public void setId(long id) {
        this.id = id;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public List<OrderPosition> getOrderPositionList() {
        return orderPositionList;
    }

    public void setOrderPositionList(List<OrderPosition> orderPositionList) {
        this.orderPositionList = orderPositionList;
    }
}
