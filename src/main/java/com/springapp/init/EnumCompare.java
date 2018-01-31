package com.springapp.init;

import java.lang.reflect.Field;

/**
 * @author luobiao
 * @date 2017-06-28
 */
public class EnumCompare {
    private String name;
    private  String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  void testmethod(){
        System.out.println("这是一个内部方法！");
    }

    private class insideClass{
        public void insidetest(){
            System.out.println("这是一个内部类");
        }
    };


    public static void main(String[] args) {
//        EnumCompare enumCompare=new EnumCompare();
//        System.out.println(enumCompare.getClass().getName());
        try {
            Field[] fields=Class.forName("com.springapp.init.EnumCompare").getDeclaredFields();
            for(Field field:fields){
                System.out.println(field);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        Field[] fields=enumCompare.getClass().getDeclaredFields();


    }

}
