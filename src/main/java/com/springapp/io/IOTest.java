package com.springapp.io;

import java.io.*;

/**
 * @author luobiao
 * @date 2017-11-29
 */
public class IOTest {
    public static void main(String[] args) throws IOException {
        String str="测试数据1";
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("E://IO1//IO2//test3.txt"));
        byte[] bytes=new byte[1000];
        bos.write(str.getBytes());
        bos.flush();
        bos.close();

        BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream("E://IO1//IO2//test4.txt"));
        BufferedReader bufferedReader=new BufferedReader(new FileReader("E://IO1//IO2//test4.txt"));

        BufferedReader in = new BufferedReader( new InputStreamReader( new FileInputStream("E://IO1//IO2//test4.txt"), "UTF-8") );
        int i;
        byte[] bytes2=new byte[1000];
        while((i=bufferedInputStream.read(bytes2))!=-1){
            System.out.println(i);
            System.out.println(bytes2.toString());
        }
        String content;
        while((content=in.readLine())!=null){
            System.out.println(content);
        }


        FileInputStream f1=new FileInputStream("E://IO1//IO2//test4.txt");
        FileInputStream f2=new FileInputStream("E://IO1//IO2//test5.txt");
        FileOutputStream outputStream=new FileOutputStream("E://IO1//IO2//test6.txt");
        SequenceInputStream sequenceInputStream=new SequenceInputStream(f1,f2);
        int c;
        while((c=sequenceInputStream.read())!=-1){
            outputStream.write(c);
        }
        f1.close();
        f2.close();
        outputStream.close();
        sequenceInputStream.close();
    }
}
