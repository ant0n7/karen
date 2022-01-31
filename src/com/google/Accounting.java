package com.google;

import java.io.Serializable;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * @author anton
 * @since 30.01.2022, So.
 **/
public class Accounting implements Serializable {
    private HashMap<Integer, Transaction> transactions;
    private Map<Integer, Customer> customers;
    private Map<Integer, Order> orders;

    public Accounting(HashMap<Integer, Transaction> transactions, Map<Integer, Customer> customers, Map<Integer, Order> orders) {
        this.transactions = transactions;
        this.customers = customers;
        this.orders = orders;
    }

    public Accounting() {
        this.transactions           = new HashMap<>();
        this.customers              = new HashMap<>();
        this.orders                 = new HashMap<>();
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

    // Functional methods

    public void startCLI() {
        int userChoice;
        do {
            IO.printStatistics(this);
            userChoice = IO.printMainMenu(this);

            switch (userChoice) {
                case 0:
                    break;
                case 1:
                    addTransaction();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    addOrder();
                    break;
                case 4:
                    IO.printAllTransactionsDetailed(this);
                    break;
                case 5:
                    IO.printAllCustomersDetailed(this);
                    break;
                case 6:
                    IO.printAllOrdersDetailed(this);
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
            Utils.promptEnterKey();
        } while (0 != userChoice);
    }

    private void addTransaction() {
        System.out.println("Adding transaction...");

        int newID = (int) transactions.keySet().toArray()[transactions.size() - 1] + 1;
        Transaction t = IO.transactionWizardCLI(this, newID);
        transactions.put(newID, t);
    }

    private void addCustomer() {
        System.out.println("Adding customer...");

        int newID = (int) customers.keySet().toArray()[customers.size() - 1] + 1;
        Customer c = IO.customerWizardCLI(this, newID);
        customers.put(newID, c);
    }

    private void addOrder() {
        System.out.println("Adding order...");

        int newID = (int) orders.keySet().toArray()[orders.size() - 1] + 1;
        Order o = IO.orderWizardCLI(this, newID);
        orders.put(newID, o);
    }

    public void testData() {
        customers.put(0, new Customer(0, "Misc", "Misc", 0, "Misc", "Misc", "Misc", "Misc"));
        customers.put(1, new Customer(1, "Google", "Coolstreet", 123, "CH-8032", "Zurich", "Switzerland", "Sundar Pichai"));
        customers.put(2, new Customer(2, "New Media GmbH", "Dorfstrasse", 7, "DE-79994", "Gelbberg", "Germany", "Max Mustermann"));
        customers.put(3, new Customer(3, "Apple", "Apple Ave.", 1, "US-29952", "Los Angeles", "USA", "Steve Jobs"));

        orders.put(0, new Order(0, "Misc", "Order object for misc. transactions", 0));
        orders.put(1, new Order(1, "Website for company", "Create a new website for the company with Wordpress", 2));
        orders.put(2, new Order(2, "Website for company", "Create a new website for the company with Wordpress", 1));
        orders.put(3, new Order(3, "SEO for current Website", "Advance the SEO for the company website", 2));
        orders.put(4, new Order(4, "Website for company", "Create a new website for the company with Wordpress", 3));

        transactions.put(1, new Transaction(1, 500, Currency.CHF, "Business Dinner", 0, LocalDate.ofYearDay(2020, 130)));
        transactions.put(2, new Transaction(2, 2400, Currency.CHF, "Payment for order", 1, LocalDate.ofYearDay(2021, 199)));
        transactions.put(3, new Transaction(3, 5500, Currency.CHF, "Second payment for order", 1, LocalDate.ofYearDay(2021, 345)));
        transactions.put(4, new Transaction(4, -3000, Currency.EUR, "Plugins for order", 1, LocalDate.ofYearDay(2020, 297)));
        transactions.put(5, new Transaction(5, 9200, Currency.USD, "Payment for order", 3, LocalDate.ofYearDay(2022, 2)));
        transactions.put(6, new Transaction(6, 17500, Currency.CHF, "Payment for website", 4, LocalDate.ofYearDay(2022, 24)));
    }
}
