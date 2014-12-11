package OpenPkgsManage.OpenPkgsDatabase;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

/**
 * Created by kevin on 12/9/14.
 */
public class OpenPkgsUI extends JFrame implements ActionListener{
    //存放行数据以及列名

    JPanel jp1,jp2;
    JLabel jl1;
    JButton jb1,jb2,jb3,jb4;
    JTable jt = null;
    JScrollPane jsp=null;
    JTextField jtf;

    OpenPkgsModel nm = null;

    public static void main(String []args){
        OpenPkgsUI op = new OpenPkgsUI();
    }

    public OpenPkgsUI()
    {
        //上部分
        jp1 = new JPanel();
        jtf = new JTextField(10);
        jb1 = new JButton("Search");
        jb1.setActionCommand("Search");
        jb1.addActionListener(this);
        jl1 = new JLabel("Name");
        jp1.add(jl1);
        jp1.add(jtf);
        jp1.add(jb1);

        //下部分
        jp2 = new JPanel();
        jb2 = new JButton("Add");
        jb2.setActionCommand("Add");
        jb2.addActionListener(this);
        jb3 = new JButton("Modify");
        jb3.setActionCommand("Modify");
        jb3.addActionListener(this);
        jb4 = new JButton("Delete");
        jb4.setActionCommand("Delete");
        jb4.addActionListener(this);
        jp2.add(jb2);
        jp2.add(jb3);
        jp2.add(jb4);

        //中间
        //创建数据模型对象
        nm = new OpenPkgsModel();
        //初始化JTable, 第一个是数据，第二个参数是列名字
        jt = new JTable(nm);

        setJTableColumnWidth(jt);
        //初始化JSP JScrollPane
        jsp = new JScrollPane(jt);

        //添加到JPanel
        this.add(jsp);
        this.add(jp1, BorderLayout.NORTH);
        this.add(jp2, BorderLayout.SOUTH);

        //Tail
        this.setSize(600,480);
        this.setLocation(300,200);
        this.setTitle("Open Packages");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    static void setJTableColumnWidth(JTable jt)
    {
        TableColumn col = jt.getColumnModel().getColumn(0);
        col.setPreferredWidth(100);
        col.setMaxWidth(120);
        col.setMinWidth(50);

        col = jt.getColumnModel().getColumn(1);
        col.setPreferredWidth(250);
        col.setMaxWidth(350);
        col.setMinWidth(200);

        col = jt.getColumnModel().getColumn(2);
        col.setPreferredWidth(30);
        col.setMaxWidth(60);
        col.setMinWidth(10);

        col = jt.getColumnModel().getColumn(3);
        col.setPreferredWidth(100);
        col.setMaxWidth(150);
        col.setMinWidth(50);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //判断是哪个按钮被点击
        if(e.getActionCommand().equals("Search"))
        {
            //重新查询数据库，更新JTable
            String name = this.jtf.getText().trim();

            //构建新的数据模型
            if(name.equals("")) {
                nm = new OpenPkgsModel();
            }else
            {
                nm = new OpenPkgsModel(name);
            }

            //更新Jtable
            jt.setModel(nm);
            setJTableColumnWidth(jt);


        }
        else if(e.getActionCommand().equals("Add"))
        {
            OpenPkgsAdd pad = new OpenPkgsAdd(this,"Add package", true);
            //构建新的数据模型
            nm = new OpenPkgsModel();

            //更新Jtable
            jt.setModel(nm);
            setJTableColumnWidth(jt);
        }
        else if(e.getActionCommand().equals("Modify"))
        {

            int rowNum = this.jt.getSelectedRow();
//                  System.out.println(rowNum);

            if(rowNum == -1)
            {
                //提示
                JOptionPane.showMessageDialog(this,"Please select a row");
                return;
            }

            OpenPkgsModify pad = new OpenPkgsModify(this,"Add package", true, nm, rowNum);
            //构建新的数据模型
            nm = new OpenPkgsModel();

            //更新Jtable
            jt.setModel(nm);
            setJTableColumnWidth(jt);

        }
        else if(e.getActionCommand().equals("Delete"))
        {
            //得到选中行的名字
            //会返回用户点中的行, 如果没有选，则返回-1
            int rowNum = this.jt.getSelectedRow();
      //      System.out.println(rowNum);

            if(rowNum == -1)
            {
                //提示
                JOptionPane.showMessageDialog(this,"Please select a row");
                return;
            }

            String name = (String)this.nm.getValueAt(rowNum,0);
            if(!name.equals("")) {
                OpenPkgsJDBC.deleteOpenPkg(name);
            }
 //           System.out.println(name);
        //    return;

            nm = new OpenPkgsModel();

            //更新Jtable
            this.jt.setModel(nm);
            setJTableColumnWidth(jt);
        }

    }
}

//JTable, 写一个TableModel
class OpenPkgsModel extends AbstractTableModel{

    Vector rowData, columnName;

    //做一个构造函数，用户初始化我们的数据模型
    public OpenPkgsModel()
    {
        columnName = new Vector();
        //设置列名
        columnName.add("Name");
        columnName.add("url");
        columnName.add("type");
        columnName.add("localPath");
        //rowData可以存放多行
        rowData = new Vector();
        List<OpenPkg> lpkg = OpenPkgsJDBC.listOpenPkgs();
//        System.out.println(lpkg.size());
        for(int i=0;i<lpkg.size();i++)
        {
            OpenPkg emp = lpkg.get(i);
            Vector row = new Vector();
            row.add(emp.getName());
            row.add(emp.getUrl());
            row.add(emp.getType());
            row.add(emp.getLocalPath());
            rowData.add(row);
        }
    }

    public OpenPkgsModel(String name)
    {
        columnName = new Vector();
        //设置列名
        columnName.add("Name");
        columnName.add("url");
        columnName.add("type");
        columnName.add("localPath");
        //rowData可以存放多行
        rowData = new Vector();
        List<OpenPkg> lpkg = OpenPkgsJDBC.getOpenPkg(name);
//        System.out.println(lpkg.size());
        for(int i=0;i<lpkg.size();i++)
        {
            OpenPkg emp = lpkg.get(i);
            Vector row = new Vector();
            row.add(emp.getName());
            row.add(emp.getUrl());
            row.add(emp.getType());
            row.add(emp.getLocalPath());
            rowData.add(row);
        }
    }

    //得到共有多少行
    @Override
    public int getRowCount() {
        return this.rowData.size();
    }

    //得到共有多少列
    @Override
    public int getColumnCount() {
        return this.columnName.size();
    }

    //得到某行某列的数据
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return ((Vector)(this.rowData.get(rowIndex))).get(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return (String)(this.columnName.get(column));
    }
}


