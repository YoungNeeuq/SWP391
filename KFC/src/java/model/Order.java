/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Asus
 */
public class Order {
    private int order_id;
    private String date;
    private int customer_id;
    private int totalmoney;

    public Order(int order_id, String date, int customer_id, int totalmoney) {
        this.order_id = order_id;
        this.date = date;
        this.customer_id = customer_id;
        this.totalmoney = totalmoney;
    }

    public Order() {
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(int totalmoney) {
        this.totalmoney = totalmoney;
    }

    @Override
    public String toString() {
        return "Order{" + "order_id=" + order_id + ", date=" + date + ", customer_id=" + customer_id + ", totalmoney=" + totalmoney + '}';
    }
    
}
