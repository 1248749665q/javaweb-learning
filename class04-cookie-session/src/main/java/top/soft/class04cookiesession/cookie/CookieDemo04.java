package com.example.class04cookiesession.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * @author lhy
 * @description: 读取并解码Cookie
 * @date 2024-10-19
 */
@WebServlet("/cookieDemo04")
public class CookieDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取Cookie数组
        Cookie[] cookies = req.getCookies();
        // 2. 遍历Cookie数组
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("chineseName".equals(name)) {
                    String value = cookie.getValue();
                    String decodedValue = URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
                    System.out.println("用户名: " + decodedValue);
                    break;
                }
            }
        }
    }
}