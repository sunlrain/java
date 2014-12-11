package com.ExTankGame;

/**
 * Created by kevin on 12/7/14.
 * 线程
 */
public class ExThread{

//    ExThreadCat ec1= null;

    public static void main(String []args){
        ExThread t1 = new ExThread();
    }

    public ExThread()
    {
 //       ec1 = new ExThreadCat();
 //       Thread tr = new Thread(ec);
 //       ec1.start();

        ExThreadTicketWindow tw1 = new ExThreadTicketWindow();
//        ExThreadTicketWindow tw2 = new ExThreadTicketWindow();
//        ExThreadTicketWindow tw3 = new ExThreadTicketWindow();

        Thread t1 = new Thread(tw1);
        Thread t2 = new Thread(tw1);
        Thread t3 = new Thread(tw1);

        t1.start();
        t2.start();
        t3.start();

    }
}

class ExThreadCat extends Thread
{
    private int counter = 0;
    @Override
    public void run() {
    //    Thread.sleep(1000);
        while(counter < 10) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Cat Thread " + counter);
            counter++;
        }
    }
}

class ExThreadTicketWindow implements Runnable
{
    private int ticketNumber = 200;  //总共200张票

//    static ExThreadCat cat = new ExThreadCat();

    @Override
    public void run() {
        while(true)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//           synchronized (cat) { //任何对象都可以
            synchronized (this) {
                //出票速度是一秒出一张

                //判断是否有票
                if (ticketNumber > 0) {
                    System.out.println(Thread.currentThread().getName() + "在出第" + ticketNumber + "张票");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    ticketNumber--;

                } else {
                    System.out.println("售票结束");
                    break;
                }
            }
        }
    }
}
