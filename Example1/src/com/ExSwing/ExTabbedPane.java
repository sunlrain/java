package com.ExSwing;

/**
 * Created by kevin on 12/3/14.
 */
//JTabbedPane 选项卡窗格(页签组件)  //网上例子

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ExTabbedPane extends JFrame{

    public static void main(String []args){
        ExTabbedPane ui = new ExTabbedPane();
        ui.initUI();
    }

    public ExTabbedPane(){
        super("学生信息管理系统");
    }

    public void initUI(){
        this.setBounds(300, 300, 500, 400);
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }});
        layoutUI();
        this.setVisible(true);
    }

    private void layoutUI(){

        //对象实例化
        JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
        //容器
        Container container = this.getLayeredPane();
        //对象化面板
        JPanel combop = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();


        tab.add(p1,"Select");
        tab.add(p2,"Updata");
        tab.add(p3,"Inserte");
        tab.add(p4,"Delete");

        combop.add(new JLabel("学生信息管理系统"));

        container.setLayout(new BorderLayout());
        container.add(combop,BorderLayout.NORTH);
        container.add(tab,BorderLayout.CENTER);

    }
}

