<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 12/11/14
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>

<%--
JSPָ��Ԫ��
  - JSP pageָ��
      Pageָ����;: Ϊ����JSPҳ�����ɵ�servletָ���߲����Ϣ
      �ܹ�����:
          ������Щ��
          ��servlet��չ�ĸ���
          ��������MIME����
          ��δ�����߳�
          servlet�Ƿ���Ự
          ����������Ĵ�С����Ϊ
          ���ĸ�ҳ������������Ĵ���
      import����
          <%@ page import="package.class" %>
          <%@ page import="package.class1,...,package.classN" %>
          Ŀ��:��servlet����Ķ������ɵ������
          ע�⣺����JSPҳ�漸�����Է��ڷ������κ�λ�ã�������JSPʹ�õ��������ڳ����servletĿ¼��
      contentType��pageEncoding����
          ָ����JSPҳ�����ɵ�servlet���ɵ�ҳ���MIME����
          ע�⣺����ֵ�����������ڼ����ó�
      errorPage����
          ��ʽ��<%@ page errorPage="Relative URL" %>
          Ŀ�ģ�ָ��һ��JSPҳ�棬�׳����쳣���δ�ڵ�ǰҳ���ڲ������ɸ�ҳ����д���@
      isErrorPage����
          ��ʽ��<%@ page isErrorPage="true" %>
          Ŀ�ģ���ǵ�ǰҳ���Ƿ������Ϊ����JSPҳ��Ĵ���ҳ��

  - JSP taglibָ��
      <% taglib uri="" prefix="" %>
        - uri: �Զ����ǩ��uri
        - prefix: ��ǩǰ׺
      Ŀ�ģ��ڵ�ǰҳ�浼���Զ����ǩ
      ʾ����ʹ��JSTL
        - <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

  - JSP includeָ��
      <%@ include file="menu.jsp" %>
      Ŀ�ģ�Ϊ���ڶ��ҳ������JSP���ݣ�������ҪJSPҳ���ܹ�Ӱ����ҳ��


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
