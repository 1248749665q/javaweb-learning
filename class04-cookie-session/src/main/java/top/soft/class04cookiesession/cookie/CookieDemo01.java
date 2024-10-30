package com.example.class04cookiesession.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lhy
 * @description: Cookie的使用示例
 * @date 2024-10-19 16:41
 */
@WebServlet("/cookieDemo01")
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建Cookie对象
        Cookie cookie = new Cookie("username", "zhangsan");
        // 通过response将cookie发送给客户端
        resp.addCookie(cookie);
        cookie.setMaxAge(60*60*24*7);
    }
}