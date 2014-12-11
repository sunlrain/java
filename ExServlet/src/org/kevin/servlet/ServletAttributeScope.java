package org.kevin.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 共享变量与变量的作用域
 * 共享变量
 *      setAttribute
 *      getAttribute
 * 变量的作用域
 *      ServletContext      //范围最大，应用程序级别，整个应用程序都能访问
 *      HttpSession         //次之，会话级别的，当前浏览器中都能访问
 *      HttpServletRequest  //范围最小，请求级别的，请求结束，变量的作用域也结束
 */

/**
 * Created by kevin on 12/10/14.
 */
@WebServlet(name = "ServletAttributeScope")
public class ServletAttributeScope extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request   //请求结束，作用域结束
        request.setAttribute("request_name","request_value");
        //session   //针对会话, 会话结束，作用域结束
        HttpSession session = request.getSession();
        session.setAttribute("session_name","session_value");
        //ServletContext 全局
        ServletContext ctx = this.getServletContext();
        ctx.setAttribute("servletContext_name","servletContext_value");

        //当前页面获得，所有上面三个参数都有
        //本页面跳转到另外一个页面: 三个参数都还在
        //直接当前浏览器输入另一个页面: session 和 servletContext的变量都还在
        //重新开一个浏览器，只有servletContext的还在
    }
}
