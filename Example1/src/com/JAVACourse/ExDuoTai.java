package com.JAVACourse;

/**
 * Created by kevin on 12/2/14.
 */
//多态
public class ExDuoTai {
    public static void main(String []args){
        Master master = new Master();
        master.feed(new ExDuoTaiDog(), new ExDuoTaiBone());
        master.feed(new ExDuoTaiCat(), new ExDuoTaiFish());
    }
}


class Master
{
    public void feed(ExDuoTaiAnimal an, ExDuoTaiFood f)
    {
        an.cry();       //多态，根据是什么动物动态选择
        f.showName();
    }
}


class ExDuoTaiFood
{
    String name;
    public void showName()
    {

    }
}

class ExDuoTaiFish extends ExDuoTaiFood
{
    public void showName()
    {
            System.out.println("This is Fish");
    }
}


class ExDuoTaiBone extends ExDuoTaiFood
{
    public void showName()
    {
        System.out.println("This is Bone");
    }
}

class ExDuoTaiAnimal
{
    int age;
    String name;

    public void cry()
    {
        System.out.println("I'm animal, Cry");
    }
}

//父类的public. protected 和不加修饰符会被继承, private 的不可以被继承
//子类只能继承一个父类

class ExDuoTaiCat extends ExDuoTaiAnimal
{
    public void cry()
    {
        System.out.println("I'm Cat, Cry");
    }
}

class ExDuoTaiDog extends ExDuoTaiAnimal
{
    public void cry()
    {
        System.out.println("I'm Dog, Cry");
    }
}

