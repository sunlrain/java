package com.JAVACourse;

/**
 * Created by kevin on 12/2/14.
 */
//覆盖
public class ExOverride {
    public static void main(String []args){
        Cat cat = new Cat();
        cat.cry();

        Dog dog = new Dog();
        dog.cry();
    }
}

class Animal
{
    public int age;
    protected String name;

    public void cry()
    {
        System.out.println("I'm animal, Cry");
    }
}

//父类的public. protected 和不加修饰符会被继承, private 的不可以被继承
//子类只能继承一个父类

class Cat extends Animal
{
    public void cry()
    {
        System.out.println("I'm Cat, Cry");
    }
}

class Dog extends Animal
{
    public void cry()
    {
        System.out.println("I'm Dog, Cry");
    }
}