package com.ExSwing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kevin on 12/3/14.
 */
// 复选框组件(JCheckBox)
// 单选框组件(JRadioButton)  : 注意，必须先创建ButtonGroup, 然后把单选框放入到ButtonGroup中
public class ExCheckboxRadio extends JFrame{

    //定义组件
    JPanel jp1,jp2,jp3;
    JLabel jl1,jl2;
    JButton jb1,jb2;
    JCheckBox jc1,jc2,jc3;
    JRadioButton jr1,jr2;
    ButtonGroup bg;


    public static void main(String []args){
        ExCheckboxRadio cr = new ExCheckboxRadio();
    }

    //构造函数
    public ExCheckboxRadio()
    {
        //创建组件
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jl1 = new JLabel("你喜欢的运动:");
        jl2 = new JLabel("你的性别");
        jb1 = new JButton("注册");
        jb2 = new JButton("取消");

        jc1 = new JCheckBox("足球");
        jc2 = new JCheckBox("网球");
        jc3 = new JCheckBox("羽毛球");

        jr1 = new JRadioButton("男");
        jr2 = new JRadioButton("女");

        ButtonGroup bg = new ButtonGroup();
        bg.add(jr1);
        bg.add(jr2);

        //设置布局管理器
        this.setLayout(new GridLayout(3,1));

        //添加组件
        jp1.add(jl1);
        jp1.add(jc1);
        jp1.add(jc2);
        jp1.add(jc3);
        jp2.add(jl2);
        jp2.add(jr1);
        jp2.add(jr2);
        jp3.add(jb1);
        jp3.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        //设置属性
        this.setTitle("CheckboxRadio Demo");
        this.setSize(300,150);
        this.setLocation(200,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }
}
