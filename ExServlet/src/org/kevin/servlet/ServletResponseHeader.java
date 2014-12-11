package org.kevin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响应头信息
 *   设置响应头信息
 *      设置任意响应头
 *          public void setHeader(String headerName, String headerValue)   -- 设定任意报头
 *          public void setDateHeader(String name, long milliseconds) 将自1970年以来的毫秒数转换成GMT格式的日期字符串
 *          public void setIntHeader(String name, int headerValue) 可以省去在调用setHeader之前将int转换成字符串的麻烦
 *          addHeader, addDateHeader, addIntHeader  --增加新报头，而非替换已有的报头
 *      普通响应报头设置
 *          setContentType
 *                 --设定Content-Type报头
 *                 --Servlet几乎总会用到这个报头
 *                 --参见常见的MIME类型的表格
 *          setContentLength
 *                  --设定Content-Length报头
 *                  --用于持续性HTTP连接
 *                  --参见Connection请求报头
 *          addCookie
 *                  --为Set-Cookie报头增加一个值
 *                  --参见介绍Cookie的部分
 *          sendRedirect
 *                  --设定Location报头(以及改变状态代码)
 *
 *    常见HTTP 1.1响应报头
 *         - Cache-Control (1.1) 和 Pragma (1.0)
 *              no-cache值阻止浏览器缓存页面
 *         - Content-Disposition
 *              通过这个报头，可以请求浏览器询问用户将响应存储到磁盘上给定的文件中
 *              Content-Disposition: attachment; filename=file-name
 *         - Content-Encoding
 *              文档的编码方式
 *         - Content-Length
 *              响应中的字节数
 *         - Content-Type
 *              返回文档时所采用的MIME类型
 *              使用setContentType设置这个报头
 *         - Expires
 *              特定的一段时间，这段时间后将该文档认做是过期，不应该再继续缓存
 *              使用setDateHeader设置这个报头
 *         - Last-Modified
 *              文档最后被改动的时间
 *              不要直接设置这个报头，而应该提供getLastModified方法
 *         - Location
 *              浏览器应该重新连接到URL
 *              不要直接设置这个报头，而要使用sendRedirect进行设定
 *         - Refresh
 *              多少秒后浏览器应该重新载入页面
 *         - Set-Cookie
 *              浏览器应该记下来cookie, 不要直接设置这个报头，而应该使用addCookie
 *         - WWW-Authenticate
 *              授权的类型和范围需要在Authorization报头中给出
 *
 */

/* 常见MIME类型 以及含义 (Google)
 */

/**
 * Created by kevin on 12/10/14.
 */
@WebServlet(name = "ServletResponseHeader")
public class ServletResponseHeader extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Example1: 输出一个excel
        response.setContentType("application/vnd.ms-excel");
        PrintWriter out = response.getWriter();

        out.println("\tQ1\tQ2\tQ3\tQ4\tTotal");
        out.println("Apples\t78\t87\t92\t29\t=SUM(B2:E2)");
        out.println("Oranges\t77\t86\t93\t30\t=SUM(B3:E3)");


    }
}
