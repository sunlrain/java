package com.JAVACourse;

/**
 * Created by kevin on 12/2/14.
 */
//接口: 接口是更加抽象的抽象类,抽象类里的方法可以有方法体，接口里的方法都没有方法体。接口体现了程序设计的多态和高内聚低耦合的设计思想
//注意事项
// 1. 接口不可以被实例化
// 2. 接口中的所有方法都不可以有主体
// 3. 一个类可以实现多个接口
// 4. 接口中可以有变量，但变量不可以用private 和 protected 修饰
//    a)接口中的变量，本质上都是static的，而且是final，不管你加不加static 修饰
//    b)在java开发中，经常把常用的变量，定义在接口中，作为全局变量使用。访问形式: 接口名.变量名
// 5. 一个接口不能继承其它的类，但是可以继承其它的接口
public class ExInterface {
    public static void main(String []args){
        ExInterfaceComputer computer = new ExInterfaceComputer();
        ExInterfaceCamera camera = new ExInterfaceCamera();
        ExInterfacePhone phone = new ExInterfacePhone();

        computer.useUsb(camera);
        computer.useUsb(phone);
    }
}

interface ExInterfaceUsb
{
    public void start();
    public void stop();
}
//当一个类实现了一个接口，就要求该类把这个接口的所有方法，通通实现
class ExInterfaceCamera implements ExInterfaceUsb
{
    public void start()
    {
        System.out.println("Camera start!!");
    }
    public void stop()
    {
        System.out.println("Camera stop");
    }

}

class ExInterfacePhone implements ExInterfaceUsb
{
    @Override
    public void start() {
        System.out.println("Phone Start");
    }

    @Override
    public void stop() {
        System.out.println("Phone Stop");
    }
}

class ExInterfaceComputer
{
    //计算机使用USB接口.... 使用的参数是interface...
    public void useUsb(ExInterfaceUsb usb)
    {
        usb.start();
        usb.stop();
    }
}