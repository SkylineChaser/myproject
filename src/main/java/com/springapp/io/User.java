package com.springapp.io;

import java.io.Serializable;

/**
 * @author luobiao
 * @date 2017-11-29
 */
public class User implements Serializable {

    private static final long serialVersionUID = -9061689160853204350L;
    private  String name;
    public transient   String password;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}