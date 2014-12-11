package com.JAVACourse;

import java.io.*;
import java.util.*;

/**
 * Created by kevin on 12/3/14.
 */
//集合: JAVA的集合类有很多种，常用的有以下几种
// 1. List结构的集合类
//    ArrayList类(往后面加 xx.add(obj)),
//    LinkedList类(可以支持后加的在前面),
//    Vector类：Vector是同步的，保证对象安全但是会影响效率
//    Stack类(往前面加)
// 2. Map结构的集合类
//    HashMap类(添加的时候有键值和对象，可以根据键值直接找到对象，类似hash表，xx.put("ID1",obj), obj=xx.get("ID1"))
//             注意添加两次键值相同的前面那个会被覆盖
//             注意遍历的话要前取出键值 Iterator
//             而且添加是无序的
//    Hashtable类: 基于陈旧的Dictionary, 是同步的，保证了里面的对象是安全的，但是效率比HashMap低
// 3. Set结构的集合类
//    HashSet类,
//    TreeSet类
// 4. Queue结构的集合
//    Queue接口


// 集合总结：
// 1. 如果要求线程安全, 使用Vector, HashTable
// 2. 如果不要求线程安全，应使用ArrayList, LinkedList, HashMap
// 3. 如果要求键值对: 使用HashMap, Hashtable
// 4. 如果数据量很大，又要线程安全，考虑Vector

public class ExJiHe {
    public static void main(String []args) throws Exception{
//HashMap集合测试
        HashMap hm = new HashMap();

        ExJiHeEmp emp1 = new ExJiHeEmp("S001","Kevin",20000f);
        ExJiHeEmp emp2 = new ExJiHeEmp("S002","Kevin2",30000f);
        ExJiHeEmp emp3 = new ExJiHeEmp("S003","Kevin3",15000f);

        hm.put("ID001", emp1);
        hm.put("ID002",emp2);
        hm.put("ID003", emp3);

        //查找
        if(hm.containsKey("ID001"))
        {
            System.out.println("This member exist");
            ExJiHeEmp emp = (ExJiHeEmp)hm.get("ID001");
            System.out.println("empNo:"+emp.getEmpNo()+"\tName:"+emp.getName());
        }

        //遍历
        Iterator it=hm.keySet().iterator();
        while(it.hasNext())
        {
            //取出Key
            String key = it.next().toString();
            //通过Key取出object
            ExJiHeEmp emp = (ExJiHeEmp)hm.get(key);
            System.out.println("empNo:"+emp.getEmpNo()+"\tName:"+emp.getName());
        }

//Array List集合 测试
        //创建EmpManger对象
        ExJiHeEmpManage em = new ExJiHeEmpManage();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //一个简易菜单
        while(true)
        {
            System.out.println("Input your operation:\n1.Add emp\t2.Show Emp\t3. Modify Sal\t4.Del Emp\t5.Show all\t6.Exit");

            String opType = br.readLine();

            if(opType.equals("1"))
            {
                System.out.print("Input EmpNo:");
                String empNo = br.readLine();
                System.out.print("Input Name;");
                String name = br.readLine();
                System.out.print("Input Salary;");
                float sal = Float.parseFloat(br.readLine());
                ExJiHeEmp emp = new ExJiHeEmp(empNo, name, sal);

                em.addEmp(emp);
            }
            else if(opType.equals("2"))
            {
                System.out.print("Input EmpNo:");
                String empNo = br.readLine();
                em.showInfo(empNo);
            }
            else if(opType.equals("3"))
            {
                System.out.print("Input EmpNo:");
                String empNo = br.readLine();
                System.out.print("Input Salary;");
                float sal = Float.parseFloat(br.readLine());
                em.updateSal(empNo, sal);
            }
            else if(opType.equals("4"))
            {
                System.out.print("Input EmpNo:");
                String empNo = br.readLine();
                em.deleteEmp(empNo);
            }
            else if(opType.equals("5"))
            {
                em.showAll();
            }
            else if(opType.equals("6"))
            {
                System.out.println("ByeBye");
                System.exit(0);
            }
        }



    }
}

//雇员管理类
class ExJiHeEmpManage
{
    private ArrayList al = null;
    //构造函数
    public ExJiHeEmpManage()
    {
        al = new ArrayList();
    }

    //加入员工
    public void addEmp(ExJiHeEmp emp)
    {
        al.add(emp);
    }

    //显示员工信息
    public void showInfo(String empNo)
    {
        for(int i=0;i<al.size();i++)
        {
            ExJiHeEmp emp = (ExJiHeEmp) al.get(i);
            if(emp.getEmpNo().equals(empNo))
            {
                System.out.println("Emp information:");
                System.out.println("empNo="+empNo);
                System.out.println("Name="+emp.getName());
                System.out.println("Salary="+emp.getSal());
            }
        }
    }

    //修改员工薪水
    public void updateSal(String empNo, float newSal)
    {
        for(int i=0;i<al.size();i++)
        {
            ExJiHeEmp emp = (ExJiHeEmp) al.get(i);
            if(emp.getEmpNo().equals(empNo))
            {
                System.out.println("Update Salary information:");
                emp.setSal(newSal);
            }
        }
    }

    //删除某个员工
    public void deleteEmp(String empNo)
    {
        for(int i=0;i<al.size();i++)
        {
            ExJiHeEmp emp = (ExJiHeEmp) al.get(i);
            if(emp.getEmpNo().equals(empNo))
            {
                al.remove(i);
            //    al.remove(emp);   可以按编号删除，或者按对象删除
            }
        }
    }

    public void showAll()
    {
        System.out.println("Emp information:\nempNo\tName\tSalary");
        for(int i=0;i<al.size();i++)
        {
            ExJiHeEmp emp = (ExJiHeEmp) al.get(i);
            System.out.print( emp.getEmpNo());
            System.out.print("\t" + emp.getName());
            System.out.print("\t" + emp.getSal() + "\n");
        }
    }
}

//雇员类
class ExJiHeEmp
{
    //雇员号, 名字, 薪水
    private String empNo;
    private String name;
    private float sal;

    //构造函数
    public ExJiHeEmp(String empNo, String name, float sal)
    {
        this.empNo = empNo;
        this.name = name;
        this.sal = sal;
    }

    //自动生成getter和setter函数
    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSal() {
        return sal;
    }

    public void setSal(float sal) {
        this.sal = sal;
    }
}