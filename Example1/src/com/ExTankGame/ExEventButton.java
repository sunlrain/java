package com.ExTankGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kevin on 12/4/14.
 */
public class ExEventButton extends JFrame implements ActionListener{
    JPanel mpb = null;
    JButton jb1,jb2;

    public static void main(String []args){
        ExEventButton ev = new ExEventButton();
    }

    public ExEventButton()
    {
        mpb = new JPanel();
        jb1 = new JButton("Black");
        jb2 = new JButton("Red");

        mpb.setBackground(Color.black);
        this.add(jb1, BorderLayout.NORTH);
        this.add(mpb);
        this.add(jb2,BorderLayout.SOUTH);

        ExEvenButtonCat cat = new ExEvenButtonCat();
        //注册监听
        jb1.addActionListener(this);
        jb1.addActionListener(cat);   //一个按钮可以有多个监听者
        //指定Action命令
        jb1.setActionCommand("black");
        jb2.addActionListener(this);
        jb2.addActionListener(cat);
        jb2.setActionCommand("red");

        this.setSize(200,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    //对时间处理的方法
    @Override
    public void actionPerformed(ActionEvent e) {

        //判断是那个按钮被点击
        if(e.getActionCommand().equals("black"))
        {
            System.out.println("Clicked black");
            mpb.setBackground(Color.black);
        }
        else if(e.getActionCommand().equals("red"))
        {
            System.out.println("Clicked red");
            mpb.setBackground(Color.red);
        }
        else
        {
            System.out.println("Unknown");
        }
    }
}

class ExEvenButtonCat implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("black"))
        {
            System.out.println("猫猫也知道你按了黑色");
        }
        else if(e.getActionCommand().equals("red"))
        {
            System.out.println("猫猫也知道你按了红色");
        }
        else
        {
            System.out.println("Unknown");
        }
    }
}
/*
class ExMyPanelEventButton extends JPanel
{
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor();
        g.fillRect(0,0,200,150);

    }
}
*/
