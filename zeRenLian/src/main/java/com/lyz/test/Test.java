package com.lyz.test;

import com.lyz.entity.Alarm;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {

    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1.获取字节码对象
        Class<?> clazz = Class.forName("com.lyz.entity.Alarm2");

        //2.通过反射技术创建目标类的对象,注意抛出异常
        /*反射创建对象方案1：
            使用 目标类 的 无参构造 创建对象
        */
        Object o = clazz.newInstance();
        System.out.println(o);//这一步已经获取到了对象Student{name='null', age=0}

        /*反射创建对象方案2：
            使用 目标类 的 全参构造 创建对象
        * 思路：
        * 1.先获取指定的构造函数对象,注意需要指定构造函数的参数，传入的是.class字节码对象
        * 2.通过刚刚获取到的构造函数对象创建Student目标类的对象，并且给对象的属性赋值
        * */

        //3.获取目标类中指定的全参构造
        Constructor<?> c = clazz.getConstructor(Integer.class, String.class);
        //System.out.println(c);

        //4.通过获取到的构造函数：创建对象 + 给对象的属性赋值
        Object o2 = c.newInstance(6,"赵六");
        System.out.println(o2);


    }
    }
