package OpenPkgsManage.OpenPkgsDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by kevin on 12/9/14.
 */
public class OpenPkgsAdd extends JDialog implements ActionListener{
    JLabel jl1,jl2,jl3,jl4;
    JButton jb1,jb2;
    JTextField jtf1,jtf2,jtf3,jtf4;
    JPanel jp1,jp2,jp3;

//    public static void main(String []args){
//
//    }

    //owner它的父框架
    //modal指定是模态窗口还是非模态窗口
    public OpenPkgsAdd(Frame owner, String title, boolean modal)
    {
        super(owner,title,modal);
        jl1 = new JLabel("Name");
        jl2 = new JLabel("URL");
        jl3 = new JLabel("Type");
        jl4 = new JLabel("LocalPath");

        jtf1 = new JTextField();
        jtf2 = new JTextField();
        jtf3 = new JTextField();
        jtf4 = new JTextField();

        jb1 = new JButton("Add");
        jb2 = new JButton("Cancel");
        jb1.addActionListener(this);
        jb2.addActionListener(this);

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        //设置布局
        jp1.setLayout(new GridLayout(4,1));
        jp2.setLayout(new GridLayout(4,1));

        //添加组件
        jp1.add(jl1);
        jp1.add(jl2);
        jp1.add(jl3);
        jp1.add(jl4);

        jp2.add(jtf1);
        jp2.add(jtf2);
        jp2.add(jtf3);
        jp2.add(jtf4);

        jp3.add(jb1);
        jp3.add(jb2);

        this.add(jp1,BorderLayout.WEST);
        this.add(jp2,BorderLayout.CENTER);
        this.add(jp3,BorderLayout.SOUTH);

        this.setSize(400,160);
        this.setLocation(400,250);
        this.setTitle(title);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                dispose();
            }
        });
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jb1)
        {
            String name = this.jtf1.getText().trim();
            String url = this.jtf2.getText().trim();
            String type = this.jtf3.getText().trim();
            String localPath = this.jtf4.getText().trim();


            OpenPkg pkg = new OpenPkg();
            pkg.setName(name);
            pkg.setUrl(url);
            pkg.setType(type);
            pkg.setLocalPath(localPath);

            OpenPkgsJDBC.addOpenPkg(pkg);

            this.dispose();

        }else if(e.getSource() == jb2)
        {
            this.dispose();
        }

    }
}
