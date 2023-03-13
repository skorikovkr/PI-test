package org.example;


import org.springframework.stereotype.Component;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class OrderRepository {

    private final HashMap<Long, Order> orders = new HashMap<>();
    Long lastId = 0L;

    public void addOrder(Order order) throws SQLException {
        var con = DriverManager.getConnection("jdbc:mysql://localhost:5432/test", "root", "7350");
        PreparedStatement stmt=con.prepareStatement("insert into orders (comment, price, date) values (?, ?, SYSDATE())");
        stmt.setString(1, order.getComment());
        stmt.setDouble(2, order.getPrice());
        stmt.executeUpdate();
        con.close();
    }

    public List<Order> getOrders() throws SQLException {
        var con = DriverManager.getConnection("jdbc:mysql://localhost:5432/test", "root", "7350");
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from orders");
        var result = new ArrayList<Order>();
        while(rs.next()) {
            var o = new Order();
            o.setId(rs.getInt("id"));
            o.setComment(rs.getString("comment"));
            o.setPrice(rs.getDouble("price"));
            o.setDate(rs.getDate("date"));
            result.add(o);
        }
        con.close();
        return result;
    }

    public void updateOrder(Long id, Order order) throws SQLException {
        var con = DriverManager.getConnection("jdbc:mysql://localhost:5432/test", "root", "7350");
        PreparedStatement stmt=con.prepareStatement("UPDATE `test`.`orders` SET `price` = ?, `comment` = ? WHERE (`id` = ?)");
        stmt.setString(2, order.getComment());
        stmt.setDouble(1, order.getPrice());
        stmt.setLong(3, id);
        stmt.executeUpdate();
        con.close();
    }

    public Order getOrder(Long id) throws SQLException {
        var con = DriverManager.getConnection("jdbc:mysql://localhost:5432/test", "root", "7350");
        PreparedStatement stmt=con.prepareStatement("select * from orders WHERE (`id` = ?)");
        stmt.setLong(1, id);
        ResultSet rs=stmt.executeQuery();
        var result = new Order();
        rs.next();
        result.setId(rs.getInt("id"));
        result.setComment(rs.getString("comment"));
        result.setPrice(rs.getDouble("price"));
        result.setDate(rs.getDate("date"));
        con.close();
        return result;
    }

    public void deleteOrder(Long id) throws SQLException {
        var con = DriverManager.getConnection("jdbc:mysql://localhost:5432/test", "root", "7350");
        PreparedStatement stmt=con.prepareStatement("DELETE FROM `test`.`orders` WHERE (`id` = ?)");
        stmt.setLong(1, id);
        stmt.executeUpdate();
        con.close();
    }
}
