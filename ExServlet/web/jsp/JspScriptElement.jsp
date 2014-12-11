<%@ page import="java.util.Calendar" %>
<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 12/11/14
  Time: 8:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
脚本元素的类型
  声明
     格式: <%! code%>
     逐字插入到servlet类的定义体中，不在任何方法之内
  表达式
     格式:<%= expression %>
     求值并插入到Servlet的输出中
     也就是会产生类似于out.print(expression)的语句
  scriptlet(代码块)
     格式: <% code %>
     逐字地插入到Servlet的_jspService方法中(由service调用)
--%>

<%--
 JSP声明和预定义变量
    -- 问题：预定义变量(request, response, out, session等)时_jspService方法中的局部变量，因而，JSP定义的方法或辅助类中的方法都不能使用他们，如何处理？
    -- 解决方案: 将它们作为参数传递
       在声明中如此定义
       <%!
          private void someMethod(HttpSession s){
            doSomeThingWith(s);
          }
       %>

       然后在代码块中调用
       <% someMethod(session); %>
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My JSP Script element demo</title>
   <%!
     int age = 30;
     String name = "kevin";
     public String hello()
     {
       return "Hello "+name;
     }
   %>

</head>
<body>
 Age:<%=age%>
 <hr>
 Name:<%=name%>
 <hr>
 <%=hello()%>
 <hr>
 <%= new java.util.Date()%>
 <hr>
 <%  //现在(2014)一般都不这样来写了,难以维护
//   String name = request.getParameter("name");
//   out.println("Attached GET data: "+name);
    if(Calendar.AM_PM ==Calendar.AM)
    {
      out.println("Good Morning");
    }
    else
    {
      out.println("Good afternoon");
    }
 %>

</body>
</html>
