package org.kevin.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Filter
 *  - Filter位于客户端和请求资源之间，在此起到过滤的作用
 *  - 请求的资源可以是 Servlet, JSP页面, HTML页面等
 *  - 在请求资源的前后来执行
 *  - 请求和响应通过Filter可以被修改
 *  - Filter常用在以下几个方面
 *      - Session管理
 *      - 权限验证
 *      - 日志纪录
 *      - 字符编码转换
 *
 * Filter接口
 *      init方法
 *      doFilter方法
 *      destroy方法
 *
 * 创建Filter的步骤
 *      创建一个类实现Filter接口:
 *          doFilter, init, destroy
 *      在doFilter方法中处理逻辑:
 *          ServletRequest, ServletResponse, FilterChain
 *      FilterChain调用doFilter方法
 *          调用下一个过滤器或实际资源
 *      注册Filter, 来过滤Servlet和JSP
 *          在web.xml中，使用filter和filter-mapping
 *
 */

//Filter 是自动执行的，不用你调用，当你访问目标资源<url-pattern>/*</url-pattern>, 该filter会自动调用

/**
 * Created by kevin on 12/11/14.
 */
@WebFilter(filterName = "FilterServlet")
public class FilterServlet implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter called");
        //在Register.html中输入中文，就不会显示乱码了
        req.setCharacterEncoding("gbk");
        resp.setCharacterEncoding("gbk");

//        //判断登陆实例, 登陆时往session里面放入user, 没有则转向另一个页面显示提示信息, 注意过滤条件不要包含 login.jsp目录
//        HttpServletRequest request = (HttpServletRequest)req;
//        HttpServletResponse response = (HttpServletResponse)resp;
//
//        HttpSession session = request.getSession();
//        String user = (String) session.getAttribute("user");
//
//        if(user!=null&&!user.equals(""))
//        {
//            chain.doFilter(req, resp);
//        }
//        else
//        {
//            String msg = "你还没有登陆";
//            request.setAttribute("error",msg);
//            request.getRequestDispatcher("/Login.jsp").forward(request,response);
//        }



        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
