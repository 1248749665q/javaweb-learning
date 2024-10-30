package com.example.class04cookiesession.cookie;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieDemo02")
public class CookieDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取请求中的cookie数组
        Cookie[] cookies = req.getCookies();

        // 检查是否有cookie数组
        if (cookies != null) {
            // 遍历cookie数组
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                // 检查cookie的名称是否为"username"
                if ("username".equals(name)) {
                    // 打印cookie的值
                    System.out.println("value的结果是: " + cookie.getValue());
                }
            }
        }
    }
}