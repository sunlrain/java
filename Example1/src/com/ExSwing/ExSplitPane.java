package com.ExSwing;

import javax.swing.*;

/**
 * Created by kevin on 12/3/14.
 */
//拆分窗格，容器类组件 JSplitPane
public class ExSplitPane extends JFrame{
    //定义组件
    JSplitPane jsp;
    JList jli;
    JLabel jl1;

    public static void main(String []args){
        ExSplitPane esp = new ExSplitPane();
    }

    public ExSplitPane()
    {
        //创建组件
        String []words = {"boy","girl","man"};
        jli = new JList(words);

        jl1 = new JLabel("Test");

        //水平拆分窗格
        jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jli,jl1);
        //可以伸缩，两边可以缩起来
        jsp.setOneTouchExpandable(true);


        //设置布局管理器

        //添加组件
        this.add(jsp);

        this.setSize(400,300);
        this.setLocation(200,200);
        this.setTitle("SplitPane Demo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
}
