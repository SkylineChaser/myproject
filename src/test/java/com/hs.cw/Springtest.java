package com.hs.cw;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author luobiao
 * @date 2017-06-26
 */
public class Springtest {
    public static void main(String[] args) {

        File file =new File("D:/test.text");
        try {
            FileOutputStream fos=new FileOutputStream(file);
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fos);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
