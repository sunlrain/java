package com.ExSwing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kevin on 12/3/14.
 */
//JPanel: 面板组件，非顶层容器
//       一个界面只可以有一个JFrame窗体组件，但可以有多个Jpanel面板组件，
//       JPanel上也可以使用FlowLayout, BorderLayout, GridLayout等布局管理器，达到较为复杂的布局效果
//       JPanel 默认布局是FlowLayout
public class ExJPanel extends JFrame{

    //定义组件
    JPanel jp1,jp2;
    JButton jb1,jb2,jb3,jb4,jb5,jb6;

    public static void main(String []args){
        ExJPanel exjp1 = new ExJPanel();

    }

    //构造函数
    public ExJPanel()
    {
        //创建组件，默认的布局时
        jp1 = new JPanel();
        jp2 = new JPanel();

        jb1 = new JButton("西瓜");
        jb2 = new JButton("苹果");
        jb3 = new JButton("荔枝");
        jb4 = new JButton("葡萄");
        jb5 = new JButton("橘子");
        jb6 = new JButton("香蕉");

        //设置布局

        //添加JPanel
        jp1.add(jb1);
        jp1.add(jb2);
        jp2.add(jb3);
        jp2.add(jb4);
        jp2.add(jb5);

        //把JPanel加入JFrame
        this.add(jp1, BorderLayout.NORTH);
        this.add(jb6, BorderLayout.CENTER);
        this.add(jp2, BorderLayout.SOUTH);

        this.setSize(300,150);
        this.setLocation(200,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }
}
