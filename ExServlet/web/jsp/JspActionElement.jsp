<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 12/11/14
  Time: 9:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
jsp:useBean  (现在(2014)基本上也不这样用了)
    格式: <jsp:useBean id="per" class="org.kevin.servlet.ListenerServlet" scope="session"/>
    目的: 不需要显式的Java变成就能够创建Java类的实例
    简单来说，上面哪个定义等同于 <% coreservlets.ListenerServlet per = new org.kevin.servlet.ListenerServlet();%>
    但jsp:usebBean拥有下面两个额外优势:
        从请求参数中导出对象的值更容易
        在页面和servlet间共享对象更容易
jsp:setProperty
jsp:getProperty
jsp:forward
    请求转发到指定文件
    <jsp:forward page="URL"/>
jsp:include
    在页面中动态包含文件
    <jsp:include page="URL" flush="true"/>
jsp:param
    获得请求参数

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%--例如:可以使用一个类，由两个成员id,name， 可以设置以及取到它的值--%>
<%--<jsp:useBean id="per" class="org.kevin.servlet.ListenerServlet" scope="session"/>--%>
<%--<jsp:setProperty name="per" property="id" value="2"/>--%>
<%--<jsp:setProperty name="per" property="name" value="kevin"/>--%>

<%--<jsp:getProperty name="per" property="id"/>--%>
<%--<jsp:getProperty name="per" property="name"/>--%>
<%--也可以这样引用:--%>
<%--$(per.id)--%>
<%--$(per.name)--%>


</body>
</html>
