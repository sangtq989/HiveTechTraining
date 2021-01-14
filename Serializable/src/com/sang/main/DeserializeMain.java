package com.sang.main;

import com.sang.DeserializeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeMain {
    public static void main(String[] args) {

        DeserializeClass object1 = null;
        String filename = "test.serialize";
        // Deserialization
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            object1 = (DeserializeClass) in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            System.out.println("a = " + object1.getName());
            System.out.println("b = " + object1.getValue());
            System.out.println("b = " + object1.getChild().getChildName() +"-"+ object1.getChild().getChildValue());

        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("ClassNotFoundException is caught");
        }
    }
}
