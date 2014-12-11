<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 12/10/14
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>Test JSP</h2>
<li>Current Time: <%=new java.util.Date()%></li>
<li>Server: <%=application.getServerInfo()%></li>
<li>Session ID: <%=session.getId()%></li>
</body>
</html>
