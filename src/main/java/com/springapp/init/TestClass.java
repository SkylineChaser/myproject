package com.springapp.init;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * @author luobiao
 * @date 2017-06-28
 */
public class TestClass implements Serializable {
    public static void main(String[] args) {
 /*       try {
            Class<?>[] declaredClasses = Class.forName("com.springapp.init.EnumCompare").getDeclaredClasses();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
*/
        Class  c=EnumCompare.class;
        EnumCompare enumCompare=new EnumCompare();
        Class  c2=enumCompare.getClass();
         try {
             Class  c1=Class.forName("com.springapp.init.EnumCompare");
            Method method= c2.getMethod("testmethod");
            System.out.println(method.getReturnType());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
