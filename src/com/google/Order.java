package com.google;

/**
 * @author anton
 * @since 30.01.2022, So.
 **/
public class Order {
    private int orderID;
    private String name;
    private String description;

    // DELETE: TEMPORARY CONSTRUCTOR
    public Order(int orderID, String name) {
        this.orderID = orderID;
        this.name = name;
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
}
