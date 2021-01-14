package com.sang.main;

import com.sang.ChildClass;
import com.sang.DeserializeClass;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeMain {

    public static void main(String[] args) {
        // write your code here
        DeserializeClass test = new DeserializeClass();
        test.setName("name ok");
        test.setValue("hehe");
        test.setChild(new ChildClass("child", 2));
        String filename = "test.serialize";
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(test);
            out.close();
            file.close();
            System.out.println("Object has been serialized");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
