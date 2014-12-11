package com.ExSwing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kevin on 12/3/14.
 */
//流式布局

// 1. 继承JFrame
// 2. 定义你要的组件
// 3. 创建组建
// 4. 添加组件到JFrame
// 5. 设置窗体属性: 如标题, size, location, 关闭时退出jvm
// 6. 显示窗体
// 7. 注意: 中间设置了布局管理器

// 流式布局注意事项
// 1. 不限制他所管理的组件大小，允许他们有最佳大小
// 2. 当容器被缩放时，组件的位置可能变化，但组件的大小不变
// 3. 默认时居中对齐,可以通过FlowLayout(int align)函数来指定对齐方式

public class ExFlowLayout extends JFrame{

    //定义组件
    JButton jb1,jb2,jb3,jb4,jb5,jb6;

    public static void main(String []args){
        ExFlowLayout bl1 = new ExFlowLayout();

    }

    public ExFlowLayout()
    {
        //创建组件
        jb1 = new JButton("Button1");
        jb2 = new JButton("Button2");
        jb3 = new JButton("Button3");
        jb4 = new JButton("Button4");
        jb5 = new JButton("Button5");
        jb6 = new JButton("Button6");

        //添加各个组件
        this.add(jb1);
        this.add(jb2);
        this.add(jb3);
        this.add(jb4);
        this.add(jb5);
        this.add(jb6);

        //设置布局管理器
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        //设置窗体属性
        this.setTitle("FlowLayout Demo");
        this.setSize(450, 200);
        this.setLocation(300, 300);

        //禁止用户改变窗体大小
        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //显示窗体
        this.setVisible(true);
    }
}

