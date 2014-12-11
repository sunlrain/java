package com.ExSwing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kevin on 12/3/14.
 */
//JTextArea 多行文本框组件
//左上角加上程序图标

public class ExQQTalk extends JFrame{
    JTextArea jta1;
    JScrollPane jsp1;
    JComboBox jcb1;
    JPanel jp1;
    JButton jb1;
    JTextField jtf1;

    public static void main(String []args){
        ExQQTalk qq = new ExQQTalk();
    }

    public ExQQTalk()
    {
        jta1 = new JTextArea();
        jsp1 = new JScrollPane(jta1);  //文本框支持滚动条

        jp1 = new JPanel();

        String []chatter = {"Kevin","Carl","Junjie"};
        jcb1 = new JComboBox(chatter);

        jtf1 = new JTextField(10);
        jb1 = new JButton("Send");

        //设置布局

        //添加组件
        jp1.add(jcb1);
        jp1.add(jtf1);
        jp1.add(jb1);

        //加入JFrame
        this.add(jsp1);
        this.add(jp1, BorderLayout.SOUTH);

        this.setSize(400,300);
        this.setLocation(200,200);
        this.setTitle("QQTalk Demo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
}
