package OpenPkgsManage.OpenPkgsDatabase;

/**
 * Created by kevin on 12/8/14.
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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

public class OpenPkgsJDBC {
    public static void main(String[] args){
        OpenPkg pkg1 = new OpenPkg();
        pkg1.setName("strongswan");
        pkg1.setUrl("git://git.strongswan.org/strongswan.git");
        pkg1.setType("git");
        pkg1.setLocalPath("strongswan");

//        addOpenPkg(pkg1);
//
//        List<OpenPkg> l1 = getOpenPkg("freebsd");
//        for(int i=0;i<l1.size();i++)
//        {
//            OpenPkg emp = l1.get(i);
//            System.out.println("Name:"+emp.getName()+"\t URL="+emp.getUrl());
//        }

        //All packages
        List<OpenPkg> l2 = listOpenPkgs();
        for(int i=0;i<l2.size();i++)
        {
            OpenPkg emp = l2.get(i);
            System.out.println(emp.getName()+"\t\t"+emp.getUrl());
        }


    }

    public static void addOpenPkg(OpenPkg pkg)
    {
        OpenPkgsJDBC exjdbc = new OpenPkgsJDBC();
        Connection conn = exjdbc.openConnection();
        String sql = "INSERT INTO OpenPkg(name,url,type,localPath) values(?,?,?,?)";  //有个?

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pkg.getName());
            pstmt.setString(2, pkg.getUrl());
            pstmt.setString(3, pkg.getType());
            pstmt.setString(4, pkg.getLocalPath());

            pstmt.executeUpdate();
 //           System.out.println(pstmt);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            exjdbc.closeConnection(conn);
        }

    }

    //Get Package according to name
    public static List<OpenPkg> getOpenPkg(String name)
    {
        OpenPkgsJDBC exjdbc = new OpenPkgsJDBC();
        Connection conn = exjdbc.openConnection();
        String sql = "select * from OpenPkg where name = ?";  //有个?

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);

            ResultSet rs = pstmt.executeQuery();

            List<OpenPkg> list = new ArrayList();
            while(rs.next())
            {
                String rsname = rs.getString("name");
                String url = rs.getString("url");
                String type = rs.getString("type");
                String localPath = rs.getString("localPath");

                OpenPkg s = new OpenPkg();
                s.setName(rsname);
                s.setUrl(url);
                s.setType(type);
                s.setLocalPath(localPath);
                list.add(s);
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            exjdbc.closeConnection(conn);
        }

        return null;
    }

    //Delete Package according to name
    public static void deleteOpenPkg(String name)
    {
        OpenPkgsJDBC exjdbc = new OpenPkgsJDBC();
        Connection conn = exjdbc.openConnection();
        String sql = "delete from OpenPkg where name=?";  //有个?

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            exjdbc.closeConnection(conn);
        }

    }

    //Delete Package according to name
    public static void updateOpenPkg( OpenPkg pkg, String name)
    {
        OpenPkgsJDBC exjdbc = new OpenPkgsJDBC();
        Connection conn = exjdbc.openConnection();
        String sql = "UPDATE OpenPkg set name=?,url=?,type=?,localPath=? where name=?";  //有个?

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pkg.getName());
            pstmt.setString(2, pkg.getUrl());
            pstmt.setString(3, pkg.getType());
            pstmt.setString(4, pkg.getLocalPath());
            pstmt.setString(5, name);

            pstmt.executeUpdate();
            //           System.out.println(pstmt);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            exjdbc.closeConnection(conn);
        }

    }

    //Get all Open packages in Database
    public static List<OpenPkg> listOpenPkgs()
    {
        OpenPkgsJDBC exjdbc = new OpenPkgsJDBC();
        Connection conn = exjdbc.openConnection();
        String sql = "select * from OpenPkg";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            List<OpenPkg> list = new ArrayList();
            while(rs.next())
            {
                String name = rs.getString("name");
                String url = rs.getString("url");
                String type = rs.getString("type");
                String localPath = rs.getString("localPath");

                OpenPkg s = new OpenPkg();
                s.setName(name);
                s.setUrl(url);
                s.setType(type);
                s.setLocalPath(localPath);
                list.add(s);
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            exjdbc.closeConnection(conn);
        }
        return null;
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

//            System.out.println(driver);
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

//    //可以得到结果集的列数，每一列的名字
//    static void testResultMetaData()
//    {
//        OpenPkgsJDBC exjdbc = new OpenPkgsJDBC();
//        Connection conn = exjdbc.openConnection();
//        String sql = "select id,name,age from test1";
//
//        try {
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//
//            ResultSetMetaData md = rs.getMetaData();
//
//            int countrow = md.getColumnCount();
//            for(int i = 1;i<=countrow;i++)
//            {
//                String name = md.getColumnName(i);
//                System.out.println(name);
//            }
//
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    static void testDatabaseMetaData()
//    {
//        OpenPkgsJDBC exjdbc = new OpenPkgsJDBC();
//        Connection conn = exjdbc.openConnection();
//
//        try {
//            DatabaseMetaData metadata = conn.getMetaData();
//
//            System.out.println("Version:"+metadata.getDatabaseMajorVersion());
//            System.out.println("Name:"+metadata.getDatabaseProductName());
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//
//    public Connection getConnection()
//    {
//        try{
//            //加载驱动
//            Class.forName("org.sqlite.JDBC");
////            Class.forName("org.mysql.jdbc.driver");
//            //建立连接
//            Connection conn = DriverManager.getConnection("jdbc:sqlite:zieckey.db");
////            Connection conn = DriverManager.getConnection("jdbc:mysql://02tx.org:3306/jdbc_db","root","password");
//            return conn;
//
//        } catch(Exception e)
//        {
//            e.printStackTrace ();
//        }
//        return null;
//    }
//
//    public Connection getConnection(String url, String driver, String username, String password)
//    {
//        try{
//            //加载驱动
//            Class.forName(driver);
//            //建立连接
//            Connection conn = DriverManager.getConnection(url);
//
//            return conn;
//
//        } catch(Exception e)
//        {
//            e.printStackTrace ();
//        }
//        return null;
//    }
//
//    //Add new table to database
//    public void createTable()
//    {
//        OpenPkgsJDBC exjdbc = new OpenPkgsJDBC();
//        Connection conn = exjdbc.openConnection();
//
//        try {
//            conn.setAutoCommit(false);      //不会自动提交，要显示提交
//            Statement stmt = conn.createStatement();
//            String sql = "create table test1(id int, name VARCHAR(20), age int) ";
//            stmt.execute(sql);
//
//            conn.commit();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            exjdbc.closeConnection(conn);
//        }
//
//    }
//
//    //可滚动,更新的结果集, SQLite不支持
//    static void updatableResultSet()
//    {
//        OpenPkgsJDBC exjdbc = new OpenPkgsJDBC();
//        Connection conn = exjdbc.openConnection();
//        String sql = "select id,name,age from test1";
//
//        try {
//            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
//            ResultSet rs = stmt.executeQuery(sql);
//
//            //添加一行
//            rs.moveToInsertRow();
//            rs.updateString("name","kite");
//            rs.updateInt(3,21);
//            rs.insertRow();
//
//            //修改第二行
//            rs.absolute(2);   //绝对定位到第2行
//            rs.updateString("name","BigTom");
//            rs.updateRow();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            exjdbc.closeConnection(conn);
//        }
//    }
//
//    //Query entries of the database
//    public void query()
//    {
//        OpenPkgsJDBC exjdbc = new OpenPkgsJDBC();
//        Connection conn = exjdbc.openConnection();
//        String sql = "select id,name,age from test1";
//
//        try {
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//
////            rs.absolute(3);   //绝对定位到第三行
//
//            while(rs.next())
//            {
//                int id = rs.getInt(1);
//                String name = rs.getString("name");
//                int age = rs.getInt("age");
//
//                int row = rs.getRow();
//
//                System.out.println("Row "+row + " -- " + id + ":" + name + ":" + age);
//
//
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            exjdbc.closeConnection(conn);
//        }
//    }

//    //Add entry to database
//    public void add()
//    {
//        OpenPkgsJDBC exjdbc = new OpenPkgsJDBC();
//        Connection conn = exjdbc.openConnection();
// //       String sql = "insert into 'tbl1' values('Kevin',9000 )";
//        String sql = "insert into test1(id,name,age) values(1, 'Kevin',26 )";
//
//        try {
//            conn.setAutoCommit(false);      //不会自动提交，要显示提交
//            Statement stmt = conn.createStatement();
//            stmt.execute(sql);
////            stmt.executeUpdate(sql);
//
//            conn.commit();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            try {
//                conn.rollback();        //Rollback，比如执行两条sql语句，第一条成功，第二条失败，则需要回滚第一条
//            } catch (SQLException e1) {
//                e1.printStackTrace();
//            }
//        }finally {
//            exjdbc.closeConnection(conn);
//        }
//
//
//    }

//
//    //Add entry to database
//    public void update()
//    {
//        OpenPkgsJDBC exjdbc = new OpenPkgsJDBC();
//        Connection conn = exjdbc.openConnection();
//        String sql = "update test1 set name='Kevin2' where name='Kevin'";
//
//        try {
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            exjdbc.closeConnection(conn);
//        }
//
//
//    }
//
//    //Remove entry from database
//    public void remove()
//    {
//        OpenPkgsJDBC exjdbc = new OpenPkgsJDBC();
//        Connection conn = exjdbc.openConnection();
//        String sql = "delete from test1 where age=26";
//
//        try {
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            exjdbc.closeConnection(conn);
//        }
//    }
}

class OpenPkg
{
    private String name;
    private String url;
    private String type; //git, svn,...
    private String localPath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }
}