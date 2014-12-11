package org.kevin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**请求头信息:
 *   读取HTTP头信息
 *      使用HttpServletRequest中的方法:
 *      一般方法:
 *          getHeader (header名称不区分大小写)
 *          getHeaders
 *          getHeaderNames
 *      专门方法:
 *          getCookies
 *          getAuthType
 *          getRemoteUser
 *          getContentLength
 *          getContentType
 *          getDateHeader
 *          getIntHeader
 *      相关信息:
 *          getMethod
 *          getRequestURI
 *          getQueryString
 *          getProtocol
 */

/**
 * Created by kevin on 12/10/14.
 */
@WebServlet(name = "ServletRequestHeader")
public class ServletRequestHeader extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求头信息
        Enumeration e = request.getHeaderNames();


        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head lang=\"en\"><Title>A Servlet</Title></head>");
        out.println("<body>");

        out.println("THis is a");
        out.println(this.getClass());

        //输出请求头信息
        out.println("<Table border=1>");
        out.println("<tr><th>Header Name</th><th>Header Value</th></tr>");
        while(e.hasMoreElements()) {
            String headerName = (String)e.nextElement();
            String headerValue = request.getHeader(headerName);
            out.println("<tr><th>"+headerName+"</th><th>"+headerValue+"</th></tr>");
        }
        out.println("</table>");

        out.println("</body>");
        out.println("</html>");
    }
}
