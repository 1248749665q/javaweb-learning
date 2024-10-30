package top.soft.bookonline.service.impl;

/**
 * @author lhy
 * @description: TODO
 * @date 2024/10/26 14:28
 */
import top.soft.bookonline.dao.BookDao;
import top.soft.bookonline.dao.impl.BookDaoImpl;
import top.soft.bookonline.entity.Book;
import top.soft.bookonline.service.BookService;
import java.util.List;

/**
 * 图书服务实现类
 */
public class BookServiceImpl implements BookService {
    private final BookDao bookDao = new BookDaoImpl();

    /**
     * 获取图书列表
     *
     * @return 图书列表
     */
    @Override
    public List<Book> getBooks() {
        return bookDao.selectAll();
    }

    /**
     * 根据ID获取图书详情
     *
     * @param id 图书ID
     * @return 图书对象
     */
    @Override
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }
}