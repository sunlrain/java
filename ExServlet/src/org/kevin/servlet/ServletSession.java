package org.kevin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Session
 *      由于HTTP协议的无状态性，无法持久保持对象的状态，那么怎么才能持久保持对象的状态呢？JAVA有两种解决方案
 *          Cookie  -- 见上一节，依赖于浏览器是否支持打开了Cookie
 *          Session
 *                Session是用来跟踪用户当前状态的一种机制，是针对浏览器和服务器的一对一关系 (换个浏览器就不生效了)
 *                Session的一般用法是，在用户登陆的时候把用户的登陆信息保存在Session中，以便以后使用
 * Session API
 *      Session 接口 HttpSession
 *          通常我们只使用httpSession接口，接口的实现由Web容器来完成
 *      获得HttpSession
 *          可以从HttpServletRequest中获得HttpSession
 *              request.getSession();
 *      将信息保存在HttpSession中
 *          session.setAttribute("UserSession",obj);
 *      从HttpSession中获得信息
 *          session.getAttribute("UserSession");
 *      使HttpSession失效
 *          session.invalidate();
 */

/**
 * Created by kevin on 12/10/14.
 */
@WebServlet(name = "ServletSession")
public class ServletSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得session实例，该接口的实现由容器提供 如tomcat
        HttpSession session = request.getSession();

        session.setAttribute("username","kevin");

        String username = (String)session.getAttribute("username");


        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head lang=\"en\"><Title>A Servlet</Title></head>");
        out.println("<body>");

        out.println("THis is a");
        out.println(this.getClass());
        out.println(", do Session test <hr>");

        out.println(username);

        out.println("</body>");
        out.println("</html>");

    }
}
