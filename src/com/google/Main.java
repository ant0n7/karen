package com.google;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // For a fresh manager run this code:
//        Accounting a = new Accounting();
//        a.startCLI();

        Accounting a = null;
        try {
            a = FileIO.readData();
        } catch (IOException e) {
            System.out.println("IO Error.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class Error.");
            e.printStackTrace();
        }

        assert a != null;
        a.startCLI();

        try {
            FileIO.saveToFile(a);
            System.out.println("Data saved.");
        } catch (IOException e) {
            System.out.println("Data not saved.");
            e.printStackTrace();
        }
    }
}
