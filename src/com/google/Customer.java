package com.google;

/**
 * @author anton
 * @since 30.01.2022, So.
 **/
public class Customer {
    private int customerID;
    private String name;

    // DELETE: TEST CONSTRUCTOR
    public Customer(int customerID, String name) {
        this.customerID = customerID;
        this.name = name;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
