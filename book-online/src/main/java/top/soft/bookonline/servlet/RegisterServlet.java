package top.soft.bookonline.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.dao.DataAccessException;
import top.soft.bookonline.entity.User;
import top.soft.bookonline.service.UserService;
import top.soft.bookonline.service.impl.UserServiceImpl;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取表单数据
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirm_password");

        // 设置响应内容类型和字符编码
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        // 简单的输入验证
        if (!password.equals(confirmPassword)) {
            // 密码不匹配
            resp.getWriter().write("<script>alert('两次输入的密码不一致，请重新输入');location.href='register.html';</script>");
            return;
        }

        // 调用注册功能
        try {
            User isRegistered = userService.signUp(account, password);
            if (isRegistered != null) {
                // 注册成功，重定向到登录页面
                resp.sendRedirect("/login-page");
            } else {
                // 注册失败，返回注册页面并提示
                resp.getWriter().write("<script>alert('注册失败，请稍后再试');location.href='register.html';</script>");
            }
        } catch (DataAccessException e) {
            // 处理数据访问异常，例如重复注册
            resp.getWriter().write("<script>alert('该账号已存在，请直接登录或重置密码');location.href='register.html';</script>");
        }
    }
}