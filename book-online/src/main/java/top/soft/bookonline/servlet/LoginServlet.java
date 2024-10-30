package top.soft.bookonline.servlet;

/**
 * @author lhy
 * @description: TODO
 * @date 2024/10/26 14:55
 */
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import top.soft.bookonline.service.UserService;
import top.soft.bookonline.service.impl.UserServiceImpl;
import top.soft.bookonline.entity.User;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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

        // 调用登录功能
        User user = userService.signIn(account, password);

        if (user != null) {
            // 登录成功，将用户对象记入session
            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            // 重定向回到/index，进入IndexServlet
            resp.sendRedirect("/index");
        } else {
            // 登录失败，设置响应内容类型
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");

            // 输出登录失败的提示信息
            resp.getWriter().write("<script>alert('账号或密码错误');location.href='/';</script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}