package com.JAVACourse;

import java.util.ArrayList;

/**
 * Created by kevin on 12/3/14.
 */
//泛型 以及 反射机制 ：
//   好处：一个是安全，另一个是提高重用率
public class ExFanXing {
    public static void main(String []args){
        ArrayList al = new ArrayList();
        //创建一只狗
        ExFanXingDog dog1 = new ExFanXingDog();
        //放入到集合
        al.add(dog1);

        //取出
        ExFanXingDog temp = (ExFanXingDog)al.get(0);  //如果没声明泛型，必须要强转语法，有安全隐患
//        ExFanXingCat temp = (ExFanXingCat)al.get(0);  //比如不小心转换成另一个类，这样编译时不会出错，但是运行时会出错

        //泛型可以很好的解决这个问题
        ArrayList<ExFanXingDog> al2 = new ArrayList<ExFanXingDog>();
        //创建一只狗
        ExFanXingDog dog2 = new ExFanXingDog();
        //放入到集合
        al2.add(dog2);

        //取出
        ExFanXingDog temp2 = al2.get(0);  //声明了泛型，不需要强制转换，编译时就会检查错误，不会留到运行时候
    }
}

class ExFanXingDog
{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}