package com.google;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anton
 * @since 30.01.2022, So.
 **/
public class Accounting {
    private DatabaseController db;

    private HashMap<Integer, Transaction> transactions;
    private Map<Integer, Customer> customers;
    private Map<Integer, Order> orders;

    private Map<Integer, Integer> transactionOrderMap;
    private Map<Integer, Integer> orderCustomerMap;

    public Accounting(HashMap<Integer, Transaction> transactions, Map<Integer, Customer> customers, Map<Integer, Order> orders, Map<Integer, Integer> transactionOrderMap, Map<Integer, Integer> orderCustomerMap) {
        this.transactions = transactions;
        this.customers = customers;
        this.orders = orders;
        this.transactionOrderMap = transactionOrderMap;
        this.orderCustomerMap = orderCustomerMap;
    }

    public Accounting() {
        this.transactions           = new HashMap<>();
        this.customers              = new HashMap<>();
        this.orders                 = new HashMap<>();
        this.transactionOrderMap    = new HashMap<>();
        this.orderCustomerMap       = new HashMap<>();
    }

    // Getters & Setters

    public HashMap<Integer, Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(HashMap<Integer, Transaction> transactions) {
        this.transactions = transactions;
    }

    public Map<Integer, Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Map<Integer, Customer> customers) {
        this.customers = customers;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<Integer, Order> orders) {
        this.orders = orders;
    }

    public Map<Integer, Integer> getTransactionOrderMap() {
        return transactionOrderMap;
    }

    public void setTransactionOrderMap(Map<Integer, Integer> transactionOrderMap) {
        this.transactionOrderMap = transactionOrderMap;
    }

    public Map<Integer, Integer> getOrderCustomerMap() {
        return orderCustomerMap;
    }

    public void setOrderCustomerMap(Map<Integer, Integer> orderCustomerMap) {
        this.orderCustomerMap = orderCustomerMap;
    }

    // Functional methods

    public void startCLI() {
        int userChoice;
        IO.printStatistics(this);
        userChoice = IO.printMainMenu(this);

        switch (userChoice) {
            case 1:
                addTransaction();
                break;
            case 2:
//                addOrder();
                break;
            case 3:
//                addCustomer();
                break;
            case 4:
//                startTransactionCLI();
                break;
            case 5:
//                startOrderCLI();
                break;
            case 6:
//                startCustomerCLI();
                break;
            case 7:
//                startStatisticsCLI();
                break;
            default:
                System.out.println("error");
                break;
        }
    }

    private void addTransaction() {
        System.out.println("Adding transaction");

        /*
        transactions.put(0, new Transaction());
        transactions.put(1, new Transaction());
        transactions.put(2, new Transaction());
        transactions.put(3, new Transaction());
        transactions.put(6, new Transaction());
        transactions.put(7, new Transaction());
        */

        Transaction t = IO.transactionWizardCLI(this);
        int newID = (int) transactions.keySet().toArray()[transactions.size() - 1] + 1;
        System.out.println(newID);

    }
}
