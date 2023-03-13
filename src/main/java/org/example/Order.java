package org.example;

import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.List;

public class Order {

    private long id;
    private String comment;
    private double price;
    private Date date;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
