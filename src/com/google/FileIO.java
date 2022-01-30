package com.google;

import java.io.*;

/**
 * @author anton
 * @since 1/31/2022, Mon
 **/
public class FileIO {
    public static Accounting readData(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream in = new ObjectInputStream(file);

        Accounting accounting = (Accounting) in.readObject();

        in.close();
        file.close();

        return accounting;
    }

    public static Accounting readData() throws IOException, ClassNotFoundException {
        return readData("data.properties");
    }

    public static void saveToFile(Accounting accounting, String fileName) throws IOException {
        FileOutputStream file = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(file);

        out.writeObject(accounting);

        out.close();
        file.close();
    }

    public static void saveToFile(Accounting accounting) throws IOException {
        saveToFile(accounting, "data.properties");
    }
}
