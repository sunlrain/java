package com.JAVACourse;

/**
 * Created by kevin on 12/2/14.
 */
//继承
public class ExExtends
{
    public static void main(String []args)
    {
        MiddleStu m1 = new MiddleStu();
        m1.pay(4000);
        System.out.println("Middle student Fee = "+m1.fee);

        ColStu c1 = new ColStu();
        c1.pay(4000);
        System.out.println("Collage student Fee = "+c1.fee);

    }
}

class Stu
{
    public int age;
    protected String name;
    float fee;
}

//父类的public. protected 和不加修饰符会被继承, private 的不可以被继承
//子类只能继承一个父类

class MiddleStu extends Stu
{
    public void pay(float fee)
    {
        this.fee = fee*0.8f;
    }
}

class ColStu extends Stu
{
    public void pay(float fee)
    {
        this.fee = fee*0.1f;
    }
}