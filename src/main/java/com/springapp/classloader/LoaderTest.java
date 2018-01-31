package com.springapp.classloader;

/**
 * @author luobiao
 * @date 2017-06-29
 */
public class LoaderTest {
    public static void main(String[] args) {
        ClassLoader loader = LoaderTest.class.getClassLoader();
        System.out.println(loader);
        //使用ClassLoader.loadClass()来加载类，不会执行初始化块
        /*
        * Class.forName()和ClassLoader.loadClass()区别
        Class.forName()：将类的.class文件加载到jvm中之外，还会对类进行解释，执行类中的static块；
        ClassLoader.loadClass()：只干一件事情，就是将.class文件加载到jvm中，不会执行static中的内容,只有在newInstance才会去执行static块。
        注：
        Class.forName(name, initialize, loader)带参函数也可控制是否加载static块。并且只有调用了newInstance()方法采用调用构造函数，创建类的对象
        * */

        try {
//            Class c=loader.loadClass("com.springapp.classloader.Test");
//            try {
//                Test t= (Test) c.newInstance();
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }

            //使用Class.forName()来加载类，默认会执行初始化块
//           Class.forName("com.springapp.classloader.Test");
            //使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块
            Class.forName("com.springapp.classloader.Test", true, loader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
