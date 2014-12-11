package com.ExSwing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kevin on 12/3/14.
 */
//边界布局演示
// 1. 继承JFrame
// 2. 定义你要的组件
// 3. 创建组建
// 4. 添加组件到JFrame
// 5. 设置窗体属性: 如标题, size, location, 关闭时退出jvm
// 6. 显示窗体

// 边界布局注意事项
// 1. 不是5个部分都必须添加
// 2. 中部组件会自动调节大小
// 3. JFrame, JDialog 默认布局管理器就是BorderLayout

public class ExBorderLayout extends JFrame{

    //定义组件
    JButton jb1,jb2,jb3,jb4,jb5;

    public static void main(String []args){
        ExBorderLayout bl1 = new ExBorderLayout();

    }

    public ExBorderLayout()
    {
        //创建组件
        jb1 = new JButton("Middle");
        jb2 = new JButton("North");
        jb3 = new JButton("East");
        jb4 = new JButton("South");
        jb5 = new JButton("West");

        //添加各个组件
//        this.add(jb1, BorderLayout.CENTER);
        this.add(jb2, BorderLayout.NORTH);
        this.add(jb3, BorderLayout.EAST);
//        this.add(jb4, BorderLayout.SOUTH);
        this.add(jb5, BorderLayout.WEST);

        //设置窗体属性
        this.setTitle("BorderLayout Demo");
        this.setSize(300, 200);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //显示窗体
        this.setVisible(true);
    }
}
