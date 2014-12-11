package com.ExSwing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kevin on 12/3/14.
 */
//下拉框组件(JComboBox)
//列表框组件(JList)
//滚动窗格组件(JScrollPane)  ： 一般来说，列表框组件和滚动窗格组件结合使用
public class ExComboBoxListScrollPane extends JFrame{
    //定义组件
    JPanel jp1,jp2;
    JLabel jl1,jl2;
    JComboBox jc1;
    JList jli1;
    JScrollPane jsp1;

    public static void main(String []args){
        ExComboBoxListScrollPane cb = new ExComboBoxListScrollPane();
    }

    //构造函数
    public ExComboBoxListScrollPane()
    {
        //创建组件
        jp1 = new JPanel();
        jp2 = new JPanel();

        jl1 = new JLabel("籍贯");
        jl2 = new JLabel("旅游地点");

        String []jg = {"北京","上海","江苏","湖南"};
        jc1 = new JComboBox(jg);

        String []dd = {"长城","故宫","太湖","中山陵","秦淮河"};
        jli1 = new JList(dd);

        //设置希望显示多少选项
        jli1.setVisibleRowCount(3);
        jsp1 = new JScrollPane(jli1);

        //设置布局
        this.setLayout(new GridLayout(3,1));

        //添加组件
        jp1.add(jl1);
        jp1.add(jc1);
        jp2.add(jl2);
        jp2.add(jsp1);

        this.add(jp1);
        this.add(jp2);

        this.setSize(300,300);
        this.setTitle("ComboBoxListScrollPane Demo");
        this.setLocation(200,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }
}
