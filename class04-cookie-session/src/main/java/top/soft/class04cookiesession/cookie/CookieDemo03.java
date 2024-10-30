package com.example.class04cookiesession.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author lhy
 * @description: TODO
 * @date 2024-10-19 14:17
 */
@WebServlet("/cookieDemo03")
public class CookieDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建cookie对象
        String value = "张三";
        Cookie cookie = new Cookie("chineseName", URLEncoder.encode(value, StandardCharsets.UTF_8.toString()));
        // 通过response将cookie发送给客户端
        resp.addCookie(cookie);
    }
}