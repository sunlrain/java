package com.ExTankGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by kevin on 12/4/14.
 */
//功能：加深对事件处理机制的理解
//通过上下左右键，来控制一个小球的位置
public class ExEventBall extends JFrame{
    ExMyPanelEventBall mp = null;

    public static void main(String []args){
        ExEventBall ev = new ExEventBall();
    }

    public ExEventBall()
    {
        mp = new ExMyPanelEventBall();

        this.add(mp);

        this.addKeyListener(mp);

        this.setSize(400,300);
        this.setLocation(200,200);
        this.setTitle("Event Ball Demo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
}

//定义自己的Panel
class ExMyPanelEventBall extends JPanel implements KeyListener
{
    int x = 100;
    int y = 100;
    public void paint(Graphics g)
    {
        super.paint(g);
        g.fillOval(x,y,10,10);
    }

    @Override
    public void keyTyped(KeyEvent e) {
  //      System.out.println("11");

    }

    @Override
    public void keyPressed(KeyEvent e) {
 //       System.out.println("22");
 //       System.out.print(e.getKeyChar());  //可以获取到按了什么键
        if(e.getKeyCode() == KeyEvent.VK_DOWN)      //按下了向下键
        {
            y++;
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            y--;
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            x--;
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            x++;
        }
        //调用repaint函数，来重绘界面
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {


    }
}
