package com.google;

import java.io.Serializable;

/**
 * @author anton
 * @since 30.01.2022, So.
 **/
public class Order implements Serializable {
    private int orderID;
    private String name;
    private String description;
    private int IDCustomer;

    public Order(int orderID, String name, String description, int IDCustomer) {
        this.orderID = orderID;
        this.name = name;
        this.description = description;
        this.IDCustomer = IDCustomer;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIDCustomer() {
        return IDCustomer;
    }

    public void setIDCustomer(int IDCustomer) {
        this.IDCustomer = IDCustomer;
    }
}
