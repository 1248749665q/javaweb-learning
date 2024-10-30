package top.soft.bookonline.servlet;

/**
 * @author lhy
 * @description: TODO
 * @date 2024/10/26 14:45
 */
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.soft.bookonline.entity.Book;
import top.soft.bookonline.service.BookService;
import top.soft.bookonline.service.impl.BookServiceImpl;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建BookService实例
        BookService bookService = new BookServiceImpl();

        // 获取图书列表
        List<Book> books = bookService.getBooks();

        // 将图书列表设置为请求属性
        req.setAttribute("bookList", books);

        // 通过服务器端转发，将数据带过去，保持地址栏不变
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}