package cn.xatu;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserServlet extends HttpServlet {

    /*
     * 自定义一个类,要继承HttpServlet类
     * 重写service方法,该方法主要就是用于处理用户请求的服务方法
     * HttpServletRequest 代表请求对象,是有请求报文经过tomcat转换而来的,通过该对象可以获取请求中的信息
     * HttpServletResponse 代表响应对象,该对象会被tomcat转换为响应的报文,通过该对象可以设置响应中的信息
     * Servlet对象的生命周期(创建,初始化,处理服务,销毁)是由tomcat管理的,无需我们自己new
     * HttpServletRequest HttpServletResponse 两个对象也是有tomcat负责转换,在调用service方法时传入给我们用的
     * */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求中的键值对参数 key=value
        String username = req.getParameter("username");
        String info = "NO";
        if ("xatu".equals(username)) {
            info = "YES";
        }
        //通过响应对象响应信息
        resp.getWriter().write(info);
    }
}
