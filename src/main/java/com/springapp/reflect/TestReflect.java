package com.springapp.reflect;

import java.io.Serializable;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luobiao
 * @date 2017-06-29
 */
public class TestReflect implements Serializable {
    private static final long serialVersionUID = 1535368884876385727L;
    private String proprety = null;
    public static void main(String[] args) {
        try {
            Class c=Class.forName("com.springapp.reflect.User");
            // 第一种方法，实例化默认构造方法
            User user= (User) c.newInstance();
            user.setAge(10);
            user.setName("lyc");
            System.out.println(user);

            Constructor[] cons=c.getConstructors();

            for (int i = 0; i < cons.length; i++) {
                Class<?> clazzs[] = cons[i].getParameterTypes();
                System.out.print("cons[" + i + "] (");
                for (int j = 0; j < clazzs.length; j++) {
                    if (j == clazzs.length - 1)
                        System.out.print(clazzs[j].getName());
                    else
                        System.out.print(clazzs[j].getName() + ",");
                }
                System.out.println(")");
            }
            try {
                User user1= (User) cons[1].newInstance(30,"lmj");
                System.out.println(user1);
                User user2= (User) cons[0].newInstance("lmj6");
                System.out.println(user2);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            Class re=TestReflect.class;
            Field[] fields=re.getDeclaredFields();
            for(int i=0;i<fields.length;i++){
                int md=fields[i].getModifiers();
                String smd=Modifier.toString(md);
                Class tc=fields[i].getType();
                System.out.println(smd + " .." + tc.getName() + " .." + fields[i].getName() + ";");
            }


            //
            Method method[] = re.getMethods();
            for (int i = 0; i < method.length; ++i) {
                Class<?> returnType = method[i].getReturnType();
                Class<?> para[] = method[i].getParameterTypes();
                int temp = method[i].getModifiers();
                System.out.print(Modifier.toString(temp) + " __");
                System.out.print(returnType.getName() + "  __");
                System.out.print(method[i].getName() + " __");
                System.out.print("(");
                for (int j = 0; j < para.length; ++j) {
                    System.out.print(para[j].getName() + " " + "arg" + j);
                    if (j < para.length - 1) {
                        System.out.print(",");
                    }
                }
                Class<?> exce[] = method[i].getExceptionTypes();
                if (exce.length > 0) {
                    System.out.print(") throws ");
                    for (int k = 0; k < exce.length; ++k) {
                        System.out.print(exce[k].getName() + " ");
                        if (k < exce.length - 1) {
                            System.out.print(",");
                        }
                    }
                } else {
                    System.out.print(")");
                }
                System.out.println();
            }

            //
            try {
                Method m1=re.getMethod("reflect1");
                Method m2=re.getMethod("reflect2",int.class,String.class);
                try {
                    m1.invoke(re.newInstance());
                    m2.invoke(re.newInstance(),20,"luobiao");
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }


            //
            Object obj = re.newInstance();
            // 可以直接对 private 的属性赋值
            Field field = null;
            try {
                field = re.getDeclaredField("proprety");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            field.setAccessible(true);
            field.set(obj, "Java反射机制");
            System.out.println(field.get(obj));

            //// 获取类加载器的方法
            TestReflect testReflect = new TestReflect();
            System.out.println("类加载器  " + testReflect.getClass().getClassLoader().getClass().getName());


            //
            MyInvocationHandler demo = new MyInvocationHandler();
            Subject sub = (Subject) demo.bind(new RealSubject());
            String info = sub.say("Rollen", 20);
            System.out.println(info);


            //
            List<Integer> arrayList=new ArrayList();
            try {
                Method mt=arrayList.getClass().getMethod("add",Object.class);
                try {
                    mt.invoke(arrayList,"这是一个String");
                    System.out.println(arrayList.get(0));
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    public void reflect1() {
        System.out.println("Java 反射机制 - 调用某个类的方法1.");
    }
    public void reflect2(int age, String name) {
        System.out.println("Java 反射机制 - 调用某个类的方法2.");
        System.out.println("age -> " + age + ". name -> " + name);
    }


    //定义项目接口
    interface Subject {
        public String say(String name, int age);
    }
    // 定义真实项目
    static class RealSubject implements Subject {
        public String say(String name, int age) {
            return name + "  " + age;
        }
    }
    static class MyInvocationHandler implements InvocationHandler {
        private Object obj = null;
        public Object bind(Object obj) {
            this.obj = obj;
            return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
        }
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object temp = method.invoke(this.obj, args);
            return temp;
        }
    }
}
