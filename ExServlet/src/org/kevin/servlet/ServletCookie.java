package org.kevin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 创建Cookie
 *      - 调用Cookie的构造函数，给出cookie的名称和Cookie的值，二者都是字符串
 *          Cookie c = new Cookie("userID","a1234");
 *      - 设置最大实效
 *          如果要告诉浏览器将cookie存储到磁盘上，而非仅仅保存在内存中，使用setMaxAge(参数为秒数)
 *          c.setMaxAge(60*60*24*7); //one Week
 *      － 将Cookie放入到HTTP响应
 *          response.addCookie(c);
 * 获得Cookie
 *      - 调用request.getCookies
 *          这会得到Cookie对象组成的数组
 *          在这个数组中循环，调用每个对象的getName,直到找到想要的cookie为止
 */

/**
 * Created by kevin on 12/10/14.
 */
@WebServlet(name = "ServletCookie")
public class ServletCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Cookie c = new Cookie("username","tom");
//        c.setMaxAge(60*60*7*24);
//        response.addCookie(c);

        //Loop and get Cookies you want
        Cookie []cookies = request.getCookies();


        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head lang=\"en\"><Title>A Servlet</Title></head>");
        out.println("<body>");

        out.println("THis is a");
        out.println(this.getClass());
        out.println(", do Cookie test <hr>");

        String msg = "welcome";
        if(cookies != null)
        {
            for(int i=0;i<cookies.length;i++)
            {
                Cookie ck = cookies[i];
                if(ck.getName().equals("username"))
                {
                    msg = "Welcome back";
                }
                else
                {
                    Cookie newck = new Cookie("username","kevin");
                    newck.setMaxAge(60*24*24*7);
                    response.addCookie(newck);
                }
            }
        }

        out.println(msg);
        out.println("</body>");
        out.println("</html>");


    }
}
