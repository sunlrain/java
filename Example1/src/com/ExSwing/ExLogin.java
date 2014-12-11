package com.ExSwing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kevin on 12/3/14.
 */
//用户登陆界面，会用到
//  文本框(JTextField)
//  密码框(JPasswordField)
//  标签(JLabel)
public class ExLogin extends JFrame{

    //定义组件
    JPanel jp1,jp2,jp3;
    JLabel jl1,jl2;
    JTextField jt1,jt2;
    JButton jb1,jb2;

    public static void main(String []args){
        ExLogin li = new ExLogin();
    }

    //构造函数
    public ExLogin()
    {
        //创建组件
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        jl1 = new JLabel("用户名:");
        jl2 = new JLabel("密码:");

        jt1 = new JTextField(10);
        jt2 = new JTextField(10);

        jb1 = new JButton("确定");
        jb2 = new JButton("取消");

        //设置布局管理
        this.setLayout(new GridLayout(3,1));

        //添加各个组件
        jp1.add(jl1);
        jp1.add(jt1);
        jp2.add(jl2);
        jp2.add(jt2);
        jp3.add(jb1);
        jp3.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        //设置属性
        this.setTitle("Login Demo");
        this.setSize(300, 150);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //显示
        this.setVisible(true);

    }
}
