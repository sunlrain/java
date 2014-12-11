package com.ExJDBC;

/**
 * Created by kevin on 12/8/14.
 */

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.List;

//import org.sqlite.JDBC;
import com.mysql.jdbc.Driver;

/**
 * JDBC常用接口和类
 * DriverManager: 驱动管理器获得数据库连接
 * Connection: 数据库连接接口
 * Statement: 语句接口，用来静态操作SQL语句
 * PreparedStatement：预定义语句，用来动态操作SQL语句
 * CallableStatement：可以调用存储过程的预定义语句
 * ResultSet：结果集，保存数据结构的结果集合
 * ResultSetMetaData：结果集元数据，如：列名称，列类型等等
 * DatabaseMetaData：数据元数据，如数据库名称，版本登
 * 程序中创建数据库、创建表、然后插入数据，
 */

//注意：JAVA数据类型和SQL数据类型的映射

public class ExJDBC{
    public static void main(String[] args){
 //       ExJDBC exjdbc = new ExJDBC();

//        Connection conn = exjdbc.openConnection();

        //事务
        //Commit rollback
//        exjdbc.createTable();
//        exjdbc.add();
//        exjdbc.update();
//        exjdbc.remove();
//        exjdbc.updatableResultSet();
//        exjdbc.query();
//        List list = listStu();

//        System.out.println(list);
        testDatabaseMetaData();
//        testResultMetaData();
//        exjdbc.closeConnection(conn);

//        getPreparedStatement(2);
//        Stu s = new Stu();
//        s.setId(2);
//        s.setName("Kevin");
//        s.setAge(22);
//        getPreparedStatementAdd(s);
    }

    static void getPreparedStatementAdd(Stu stu)
    {
        ExJDBC exjdbc = new ExJDBC();
        Connection conn = exjdbc.openConnection();
        String sql = "INSERT INTO test1(id,name,age) values(?,?,?)";  //有个?

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, stu.getId());
            pstmt.setString(2, stu.getName());
            pstmt.setInt(3, stu.getAge());

            pstmt.executeUpdate();
            System.out.println(pstmt);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    static void getPreparedStatement(int id)
    {
        ExJDBC exjdbc = new ExJDBC();
        Connection conn = exjdbc.openConnection();
        String sql = "select id,name,age from test1 where id = ?";  //有个?

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            System.out.println(pstmt);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //可以得到结果集的列数，每一列的名字
    static void testResultMetaData()
    {
        ExJDBC exjdbc = new ExJDBC();
        Connection conn = exjdbc.openConnection();
        String sql = "select id,name,age from test1";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            ResultSetMetaData md = rs.getMetaData();

            int countrow = md.getColumnCount();
            for(int i = 1;i<=countrow;i++)
            {
                String name = md.getColumnName(i);
                System.out.println(name);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void testDatabaseMetaData()
    {
        ExJDBC exjdbc = new ExJDBC();
        Connection conn = exjdbc.openConnection();

        System.out.println(conn);
        try {
            DatabaseMetaData metadata = conn.getMetaData();

            System.out.println("Version:"+metadata.getDatabaseMajorVersion());
            System.out.println("Name:"+metadata.getDatabaseProductName());


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection openConnection()
    {
        Properties prop = new Properties();
        String driver = null;
        String url = null;
        String username = null;
        String password = null;

        try {
            prop.load(this.getClass().getClassLoader().getResourceAsStream("DBConfig.properties"));

            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");

            System.out.println(driver);
            //加载驱动
            Class.forName(driver);
            //建立连接
            return DriverManager.getConnection(url,username,password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void closeConnection(Connection conn)
    {
        if(conn!=null)
        {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public Connection getConnection()
    {
        try{
            //加载驱动
            Class.forName("org.sqlite.JDBC");
//            Class.forName("org.mysql.jdbc.driver");
            //建立连接
            Connection conn = DriverManager.getConnection("jdbc:sqlite:zieckey.db");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://02tx.org:3306/jdbc_db","root","password");
            return conn;

        } catch(Exception e)
        {
            e.printStackTrace ();
        }
        return null;
    }

    public Connection getConnection(String url, String driver, String username, String password)
    {
        try{
            //加载驱动
            Class.forName(driver);
            //建立连接
            Connection conn = DriverManager.getConnection(url);

            return conn;

        } catch(Exception e)
        {
            e.printStackTrace ();
        }
        return null;
    }

    //Add new table to database
    public void createTable()
    {
        ExJDBC exjdbc = new ExJDBC();
        Connection conn = exjdbc.openConnection();

        try {
            conn.setAutoCommit(false);      //不会自动提交，要显示提交
            Statement stmt = conn.createStatement();
            String sql = "create table test1(id int, name VARCHAR(20), age int) ";
            stmt.execute(sql);

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            exjdbc.closeConnection(conn);
        }

    }

    //可滚动,更新的结果集, SQLite不支持
    static void updatableResultSet()
    {
        ExJDBC exjdbc = new ExJDBC();
        Connection conn = exjdbc.openConnection();
        String sql = "select id,name,age from test1";

        try {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(sql);

            //添加一行
            rs.moveToInsertRow();
            rs.updateString("name","kite");
            rs.updateInt(3,21);
            rs.insertRow();

            //修改第二行
            rs.absolute(2);   //绝对定位到第2行
            rs.updateString("name","BigTom");
            rs.updateRow();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            exjdbc.closeConnection(conn);
        }
    }

    static List listStu()
    {
        ExJDBC exjdbc = new ExJDBC();
        Connection conn = exjdbc.openConnection();
        String sql = "select id,name,age from test1";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

//            rs.absolute(3);   //绝对定位到第三行
            List list = new ArrayList();
            while(rs.next())
            {
                int id = rs.getInt(1);
                String name = rs.getString("name");
                int age = rs.getInt("age");

                Stu s = new Stu();
                s.setAge(age);
                s.setId(id);
                s.setName(name);
                list.add(s);
 //               int row = rs.getRow();
 //               System.out.println("Row "+row + " -- " + id + ":" + name + ":" + age);
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            exjdbc.closeConnection(conn);
        }
        return null;
    }
    //Query entries of the database
    public void query()
    {
        ExJDBC exjdbc = new ExJDBC();
        Connection conn = exjdbc.openConnection();
        String sql = "select id,name,age from test1";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

//            rs.absolute(3);   //绝对定位到第三行

            while(rs.next())
            {
                int id = rs.getInt(1);
                String name = rs.getString("name");
                int age = rs.getInt("age");

                int row = rs.getRow();

                System.out.println("Row "+row + " -- " + id + ":" + name + ":" + age);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            exjdbc.closeConnection(conn);
        }
    }

    //Add entry to database
    public void add()
    {
        ExJDBC exjdbc = new ExJDBC();
        Connection conn = exjdbc.openConnection();
 //       String sql = "insert into 'tbl1' values('Kevin',9000 )";
        String sql = "insert into test1(id,name,age) values(1, 'Kevin',26 )";

        try {
            conn.setAutoCommit(false);      //不会自动提交，要显示提交
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
//            stmt.executeUpdate(sql);

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();        //Rollback，比如执行两条sql语句，第一条成功，第二条失败，则需要回滚第一条
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            exjdbc.closeConnection(conn);
        }


    }


    //Add entry to database
    public void update()
    {
        ExJDBC exjdbc = new ExJDBC();
        Connection conn = exjdbc.openConnection();
        String sql = "update test1 set name='Kevin2' where name='Kevin'";

        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            exjdbc.closeConnection(conn);
        }


    }

    //Remove entry from database
    public void remove()
    {
        ExJDBC exjdbc = new ExJDBC();
        Connection conn = exjdbc.openConnection();
        String sql = "delete from test1 where age=26";

        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            exjdbc.closeConnection(conn);
        }
    }
}

class Stu
{
    private int id;
    private int age;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}