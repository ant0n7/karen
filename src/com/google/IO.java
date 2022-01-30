package com.google;

import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;

/**
 * @author anton
 * @since 30.01.2022, So.
 **/
public class IO {
    private static final String MENU_INPUT_STRING = "  " + Output.BOX_FAT.CORNER_LEFT_LOWER + " ";

    public static void printStatistics(Accounting a) {
        System.out.println("General Stats");
        System.out.println("Transactions    " + a.getTransactions().size());
        System.out.println("Customers       " + a.getCustomers().size());
        System.out.println("Orders          " + a.getOrders().size());
    }

    public static int printMainMenu(Accounting a) {
        String[] menuOptions = {
                "1 - Add Transaction",
                "2 - Add Customer",
                "3 - Add Order",
                "          ",
                "5 - Transactions...",
                "6 - Orders...",
                "7 - Customers...",
                "8 - Statistics...",
                "          ",
                "0 - Quit"
        };
        Output.printMenu(Output.MAIN_MENU, "ACCOUNTING MENU", menuOptions);

        return Utils.scanRangedInt(0, 8, MENU_INPUT_STRING);
    }

    public static Transaction transactionWizardCLI(Accounting accounting, int transactionID) {
        Output.printBox("NEW TRANSACTION");
        double amount = Utils.scanRangedDouble(-999999999, 999999999, "Amount of money: ");


        Output.printList(Output.ListType.UNORDERED, getEnumNames(Currency.class));
        Currency currency;
        while (true) {
            String currencyString = Utils.scanAlphabeticString("Currency: ");
            if (stringInArray(getEnumNames(Currency.class), currencyString)) {
                currency = Currency.valueOf(currencyString);
                System.out.println(currency.name());
                break;
            }
        }

        String purpose = Utils.scanString("Purpose of transaction: ");


        printAllOrders(accounting);
        int IDOrder;
        do {
            IDOrder = Utils.scanRangedInt(0, 99999999, "Connected Order ID (None=0): ");
        } while (!accounting.getOrders().containsKey(IDOrder) && 0 != IDOrder);

        // Date of transaction
        System.out.println("Transaction Date");
        int year = Utils.scanRangedInt(LocalDate.MIN.getYear(), LocalDate.MAX.getYear(), "Year: ");
        int month = Utils.scanRangedInt(LocalDate.MIN.getMonthValue(), LocalDate.MAX.getMonthValue(), "Month: ");
        int day = Utils.scanRangedInt(LocalDate.MIN.getDayOfMonth(), LocalDate.MAX.getDayOfMonth(), "Day: ");
        LocalDate date = LocalDate.of(year, month, day);

        return new Transaction(transactionID, amount, currency, purpose, IDOrder, date);
    }

    public static Customer customerWizardCLI(Accounting accounting, int customerID) {
        Output.printBox("NEW CUSTOMER");

        String name = Utils.scanString("Name: ");
        String street = Utils.scanString("Street: ");
        int houseNumber = Utils.scanRangedInt(1, 999999, "House Number: ");
        String zip = Utils.scanString("ZIP: ");
        String city = Utils.scanString("City: ");
        String country = Utils.scanString("Country: ");
        String personOfContact = Utils.scanString("Person of contact: ");

        return new Customer(customerID, name, street, houseNumber, zip, city, country, personOfContact);
    }

    public static Order orderWizardCLI(Accounting accounting, int orderID) {
        Output.printBox("NEW ORDER");

        String name = Utils.scanString("Name: ");
        String description = Utils.scanString("Description: ");

        printAllCustomers(accounting);
        int IDCustomer;
        do {
            IDCustomer = Utils.scanRangedInt(0, 99999999, "Connected Customer ID (None=0): ");
        } while (!accounting.getCustomers().containsKey(IDCustomer) && 0 != IDCustomer);

        return new Order(orderID, name, description, IDCustomer);
    }

    public static String[] getEnumNames(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }

    public static boolean stringInArray(String[] arr, String s) {
        boolean check = false;

        for (String arrStr : arr) {
            if (arrStr.equals(s)) {
                check = true;
                break;
            }
        }

        return check;
    }

    public static boolean intInArray(int[] arr, int i) {
        boolean check = false;

        for (int arrInt : arr) {
            if (arrInt == i) {
                check = true;
                break;
            }
        }

        return check;
    }
    
    public static void printAllCustomers(Accounting accounting) {
        System.out.println("All Customers");
        for (int id :
                accounting.getCustomers().keySet()) {
            printCustomer(accounting.getCustomers().get(id));
        }
    }

    public static void printCustomer(Customer c) {
        Output.printBox(c.getName() + " (ID=" + c.getCustomerID() + ")");
    }

    public static void printAllOrders(Accounting accounting) {
        System.out.println("All Orders");
        for (int id :
                accounting.getOrders().keySet()) {
            printOrder(accounting.getOrders().get(id));
        }
    }

    public static void printOrder(Order o) {
        Output.printBox(o.getName() + " (ID=" + o.getOrderID() + ")");
    }
}
