package cn.xatu;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet {

    /*
     * 自定义一个类,要继承HttpServlet类
     * 重写service方法,该方法主要就是用于处理用户请求的服务方法
     * HttpServletRequest 代表请求对象,是有请求报文经过tomcat转换而来的,通过该对象可以获取请求中的信息
     * HttpServletResponse 代表响应对象,该对象会被tomcat转换为响应的报文,通过该对象可以设置响应中的信息
     * Servlet对象的生命周期(创建,初始化,处理服务,销毁)是由tomcat管理的,无需我们自己new
     * HttpServletRequest HttpServletResponse 两个对象也是有tomcat负责转换,在调用service方法时传入给我们用的
     *
     * 1.servlet-api.jar,在编译构建项目的时候需要；在运行时不需要，因为项目在Tomcat容器中，Tomcat中已经存在servlet-api.jar。
     * 2.contentType响应头问题：需要服务端告诉客户端，返回的数据是什么格式，客户端才能解析
     * */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求中的键值对参数 key=value,无论参数是在url?后，还是在请求体中，均可通过getParameter方法获取
        String username = req.getParameter("username");
        String info = "<h1>NO</h1>";
        if ("xatu".equals(username)) {
            info = "<h1>YES</h1>";
        }
        // setContentType特别重要，需要给响应头设置数据类型，以便浏览器解析。
        resp.setContentType("text/html");
        //通过响应对象响应信息
        PrintWriter printWriter = resp.getWriter(); // 该方法返回的是一个响应体中打印字符串的 打印流
        printWriter.write(info);
    }
}
