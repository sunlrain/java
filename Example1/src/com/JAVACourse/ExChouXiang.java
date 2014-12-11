package com.JAVACourse;

/**
 * Created by kevin on 12/2/14.
 */
public class ExChouXiang {
    public static void main(String []args){
        ExChouXiangCat cat = new ExChouXiangCat();
        cat.cry();

//        ExChouXiangAnimal an = new ExChouXiangAnimal(); //不可以，抽象类不可以实例化，里面还有没实现的方法呢
    }
}

//抽象类, 可以没有抽象方法，但是也不可以实例化，一旦此类中有一个抽象方法，此类则必须声明为抽象类
abstract class ExChouXiangAnimal
{
    String name;
    int age;
    abstract public void cry();  //抽象方法不能在这里实现，要在子类中实现
}

//继承了抽象类，需要把父类中的全部抽象方法实现
class ExChouXiangCat extends ExChouXiangAnimal
{
    public void cry()
    {
        System.out.println("Cry, cat");
    }
}

class ExChouXiangDog extends ExChouXiangAnimal
{
    public void cry()
    {
        System.out.println("Cry, dog");
    }
}