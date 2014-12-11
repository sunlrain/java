package com.JAVACourse;

/**
 * Created by kevin on 12/2/14.
 */
//重载
public class ExOverload {
    public static void main(String []args)
    {
        Abc test1 = new Abc();
        System.out.println("Get Max(10,20) = "+test1.getMax(10, 20));
        System.out.println("Get Max(23.3f,29.9f) = "+test1.getMax(23.3f,29.9f));
    }
}

class Abc
{
    public int getMax(int i, int j)
    {
        System.out.println("getMax -- int");
        if(i>j)
        {
            return i;
        }
        else
        {
            return j;
        }
    }

    public float getMax(float i, float j)
    {
        System.out.println("getMax -- float");
        if(i>j)
        {
            return i;
        }
        else
        {
            return j;
        }
    }
}
