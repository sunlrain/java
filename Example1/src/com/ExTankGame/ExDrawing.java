package com.ExTankGame;

//Java绘图原理

import javax.swing.*;
import java.awt.*;

/**
 * Created by kevin on 12/4/14.
 */
public class ExDrawing extends JFrame{
    ExMyPanelDemo mp = null; //一些画图示例
//    ExMyPanelTank mp = null;  //画图坦克

    public static void main(String []args){
        ExDrawing ex = new ExDrawing();
    }

    public ExDrawing()
    {
        mp = new ExMyPanelDemo();  //一些画图示例
//        mp = new ExMyPanelTank();
        this.add(mp);

        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

//一些画图示例: 定义一个MyPanel(我自己的面板，用于绘图和实现绘图的区域)
class ExMyPanelDemo extends JPanel {
    //覆盖JPanel的paint方法
    //Graphics是绘图的重要类，相当于一支画笔
/*
    绘图原理:
    1. Component类提供了两个绘图相关最重要的方法:
        Paint(Graphics g)绘制组件的外观
        repaint()函数刷新组件外观
    2. 在以下情况下paint将会被调用
        窗口最小化，再最大化
        窗口大小发生变化
        repaint函数被调用
*/
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        System.out.println("Paint called");

        //画出一个圆
        g.drawOval(10,10,30,30);

        //画直线
        g.drawLine(10, 10, 40, 40);

        //画一个3D矩形
        g.drawRect(60, 60, 30, 30);
        //设置颜色,填充矩形
        g.setColor(Color.RED);
        g.fillRect(60, 60, 30, 30);

        //面板上画图片
        Image im=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/aaa.gif"));
        g.drawImage(im,150,30,100,100,this);

        //画出一个字
        g.setColor(Color.BLUE);
        g.setFont(new Font("华文彩云", Font.BOLD, 30));
        g.drawString("I love China", 100,20);


    }
}

//我的Tank面板
class ExMyPanelTank extends JPanel
{
    MyTank tk = null;

    public ExMyPanelTank()
    {
        tk = new MyTank(100,100);

    }

    //重新Paint
    public void paint(Graphics g)
    {
        super.paint(g);

        g.fillRect(0,0,400,300);

        drawTank(tk.getX(),tk.getY(),g,0,1);

    }

    //画出我的坦克
    public void drawTank(int x, int y, Graphics g, int direction, int type)
    {
        //判断是什么类型的坦克，0是自己的，1是别人的
        switch(type)
        {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }
        
        //判断方向
        switch(direction)
        {
            //向上
            case 0:
                //画出左边矩形
                g.fill3DRect(x, y, 5, 30, false);
                //画出右边矩形
                g.fill3DRect(x + 15, y, 5, 30, false);
                //画出中间矩形
                g.fill3DRect(x + 5, y + 5, 10, 20, false);
                //画出圆形
                g.fillOval(x+5,y+10,10,10);
                //画出线:炮筒
                g.drawLine(x+10,y+15,x+10,y);
                break;
        }

    }
}
