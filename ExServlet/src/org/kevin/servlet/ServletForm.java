package org.kevin.servlet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by kevin on 12/9/14.
 */
//使用Servlet处理表单
//读取单个请求参数 String user = request.getParameter("user")
//读取多个表单  String []hobby = request.getParameterValues("hobby");  //比如复选框多个爱好
//读取所有参数 Enumeration names = request.getParameterNames();
@WebServlet(name = "ServletFrom")
public class ServletForm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><Title>A Servlet</Title></head>");
        out.println("<body>");

        out.println("THis is a");
        out.println(this.getClass());

        out.println(", using the POST method");

        out.println("Username:"+username);
        out.println("Password:"+password);

        //Execuate ifconfig and get result
        //       out.println(Runtime.getRuntime().exec("ifconfig"));
        Runtime r = Runtime.getRuntime();
        Process p;
        try {

            p = r.exec("ifconfig");
            BufferedReader br = new BufferedReader(new InputStreamReader(p
                    .getInputStream()));
            String inline = null;
            while ((inline = br.readLine()) != null) {
                out.println(inline);
 //               System.out.println(inline);

            }
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        out.println("</body>");
        out.println("</html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
