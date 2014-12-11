package com.ExSwing;

import javax.swing.*;

/**
 * Created by kevin on 12/3/14.
 */
//JFrame 和 基本的JButton范例
public class ExJFrame extends JFrame{

    //把需要的组件定义到这里，创建部分放到下面的构造函数
    JButton jb1 = null;


    public static void main(String []args) {
        ExJFrame jf1 = new ExJFrame();
    }

    //构造函数
    public ExJFrame()
    {

        //JFrame 是一个顶层容器类(可以添加其它swing组件的类)
      //  JFrame jf = new JFrame();    //不在此创建了，外面类继承JFrame
        //创建一个Button
      //  JButton jb1 = new JButton("I'm Button");
        jb1 = new JButton("I'm a Button");

        //给窗体设置标题
        this.setTitle("Hello World!");

        //设置大小，按像素
        this.setSize(200, 200);
        //添加Button
        this.add(jb1);

        //设置初始位置
        this.setLocation(200, 200);

        //设置默认的关闭操作,关闭程序时保证jvm也退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //显示
        this.setVisible(true);

    }

}
