/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Asus
 */
public class Invoice {
    private String invoice_id;
    private String nameOfDish;
    private int quantity;
    private String address;
    private String store_phoneNumber;
    private int invoice_price;
    private int customer_id;
    private int order_id;

    public Invoice() {
    }

    public Invoice(String invoice_id, String nameOfDish, int quantity, String address, String store_phoneNumber, int invoice_price, int customer_id) {
        this.invoice_id = invoice_id;
        this.nameOfDish = nameOfDish;
        this.quantity = quantity;
        this.address = address;
        this.store_phoneNumber = store_phoneNumber;
        this.invoice_price = invoice_price;
        this.customer_id = customer_id;
    }

    public Invoice(String invoice_id, String nameOfDish, int quantity, String address, String store_phoneNumber, int invoice_price, int customer_id, int order_id) {
        this.invoice_id = invoice_id;
        this.nameOfDish = nameOfDish;
        this.quantity = quantity;
        this.address = address;
        this.store_phoneNumber = store_phoneNumber;
        this.invoice_price = invoice_price;
        this.customer_id = customer_id;
        this.order_id = order_id;
    }

    public String getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(String invoice_id) {
        this.invoice_id = invoice_id;
    }

    public String getNameOfDish() {
        return nameOfDish;
    }

    public void setNameOfDish(String nameOfDish) {
        this.nameOfDish = nameOfDish;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStore_phoneNumber() {
        return store_phoneNumber;
    }

    public void setStore_phoneNumber(String store_phoneNumber) {
        this.store_phoneNumber = store_phoneNumber;
    }

    public int getInvoice_price() {
        return invoice_price;
    }

    public void setInvoice_price(int invoice_price) {
        this.invoice_price = invoice_price;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
    
}
