<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 12/11/14
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>

<%--
JSP指令元素
  - JSP page指令
      Page指令用途: 为根据JSP页面生成的servlet指定高层的信息
      能够控制:
          导入哪些类
          该servlet扩展哪个类
          产生哪种MIME类型
          如何处理多线程
          servlet是否共享会话
          输出缓冲区的大小的行为
          由哪个页面来处理意外的错误
      import属性
          <%@ page import="package.class" %>
          <%@ page import="package.class1,...,package.classN" %>
          目的:在servlet定义的顶部生成导入语句
          注意：尽管JSP页面几乎可以放在服务器任何位置，但是由JSP使用的类必须放在常规的servlet目录中
      contentType和pageEncoding属性
          指定由JSP页面生成的servlet生成的页面的MIME类型
          注意：属性值不能在请求期间计算得出
      errorPage属性
          格式：<%@ page errorPage="Relative URL" %>
          目的：指定一个JSP页面，抛出的异常如果未在当前页面内捕获，则由该页面进行处理@
      isErrorPage属性
          格式：<%@ page isErrorPage="true" %>
          目的：标记当前页面是否可以作为其它JSP页面的错误页面

  - JSP taglib指令
      <% taglib uri="" prefix="" %>
        - uri: 自定义标签的uri
        - prefix: 标签前缀
      目的：在当前页面导入自定义标签
      示例：使用JSTL
        - <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

  - JSP include指令
      <%@ include file="menu.jsp" %>
      目的：为了在多个页面重用JSP内容，而且需要JSP页面能够影响主页面


--%>
<%@page language="java" import="java.util.*" pageEncoding="gbk" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
</head>
<body>

</body>
</html>
