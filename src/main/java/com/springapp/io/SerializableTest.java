package com.springapp.io;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.PropertyResolver;

import java.io.*;

/**
 * @author luobiao
 * @date 2017-11-28
 */
public class SerializableTest {
    public static void main(String[] args) throws IOException{
        User user=new User();
        user.setName("James");
        user.setPassword("123456");

        System.out.println("Before Serializable:" + user.toString());
        ObjectOutputStream os=new ObjectOutputStream(new  FileOutputStream("E://IO1/IO2/test2.txt"));
        os.writeObject(user);
        os.flush();
        os.close();


        ObjectInputStream is=new ObjectInputStream(new FileInputStream("E://IO1/IO2/test2.txt"));
        try {
            user= (User) is.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        is.close();

        System.out.println("After Serializable:" + user.toString());
    }



}
