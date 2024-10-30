package top.soft.bookonline.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// 使用@WebServlet注解来声明这个类是一个Servlet，并定义它的URL模式
@WebServlet("/register-page")
public class RegisterPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 转发请求到register.html页面
        req.getRequestDispatcher("/register.html").forward(req, resp);
    }
}