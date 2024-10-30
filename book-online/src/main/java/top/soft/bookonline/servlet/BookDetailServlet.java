package top.soft.bookonline.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.soft.bookonline.entity.Book;
import top.soft.bookonline.service.BookService;
import top.soft.bookonline.service.impl.BookServiceImpl;

import java.io.IOException;

@WebServlet(urlPatterns = "/detail/*")
public class BookDetailServlet extends HttpServlet {
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的URI,并去除空格
        String requestPath = req.getRequestURI().trim();

        // 获得最后一个"/"的位置
        int position = requestPath.lastIndexOf("/");

        // 从该位置到最后取子串，即ID
        String id = requestPath.substring(position + 1);

        // 根据ID查找图书
        Book book = bookService.getBookById(Integer.parseInt(id));

        // 将图书对象设置为请求属性
        req.setAttribute("book", book);

        // 通过服务器端转发，将数据带过去，保持地址栏不变
        req.getRequestDispatcher("/book_detail.jsp").forward(req, resp);
    }
}