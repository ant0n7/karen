package com.google;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author anton
 * @since 30.01.2022, So.
 **/
public class Transaction implements Serializable {
    private int transactionID;
    private double amount;
    private Currency currency;
    private String purpose;
//    Customer customer;
    private int IDOrder; // referencing to an order -> ID prefix for foreign keys
    private LocalDate date;

    public Transaction(int transactionID, double amount, Currency currency, String purpose, int IDOrder, LocalDate date) {
        this.transactionID = transactionID;
        this.amount = amount;
        this.currency = currency;
        this.purpose = purpose;
        this.IDOrder = IDOrder;
        this.date = date;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public int getIDOrder() {
        return IDOrder;
    }

    public void setIDOrder(int IDOrder) {
        this.IDOrder = IDOrder;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
