package com.ExSwing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kevin on 12/3/14.
 */
//网格布局 : 容器被分成多行多列，组件被填充到各个网格中
// 1. 继承JFrame
// 2. 定义你要的组件
// 3. 创建组建
// 4. 添加组件到JFrame
// 5. 设置窗体属性: 如标题, size, location, 关闭时退出jvm
// 6. 显示窗体

// 网格布局注意事项
// 1. 组件的相对位置不随容器的缩放而变化，但大小会变化
// 2. 所有组件大小相同
// 3. 可以通过GridLayout(int rows, int cols, int hgap, int vgap) 来指定网格的行/列，水平间隙/垂直间隙

public class ExGridLayout extends JFrame {

    //定义组件
    int size = 9;
    JButton jbs[] = new JButton[size];

    public static void main(String []args){
        ExGridLayout bl1 = new ExGridLayout();

    }

    public ExGridLayout()
    {
        //创建组件
        for(int i=0;i<size;i++)
        {
            jbs[i] = new JButton(String.valueOf(i));
        }

        this.setLayout(new GridLayout(3,3,10,10));

        //添加组件
        for(int i=0;i<size;i++)
        {
            this.add(jbs[i]);
        }

        //设置窗体属性
        this.setTitle("GridLayout Demo");
        this.setSize(300, 200);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //显示窗体
        this.setVisible(true);
    }
}

