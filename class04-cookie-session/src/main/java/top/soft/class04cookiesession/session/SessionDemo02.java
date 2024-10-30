package com.example.class04cookiesession.session;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author lhy
 * @description: TODO
 * @date 2024/10/19 14:51
 */

@WebServlet("/sessionDemo02")
public class SessionDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取Session对象
        HttpSession session = req.getSession();
        // 获取Session中的属性
        Object username = session.getAttribute("username");
        // 打印属性值
        System.out.println(username);
    }
}