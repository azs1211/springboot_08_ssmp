package com.itheima.dao;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ZiShao
 * @create 2022-12-30 16:32
 **/
@SpringBootTest
public class BookDaoTestCase {
    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById() {
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("测试1111111");
        book.setName("测试1111111");
        book.setDescription("测试1111111");
        bookDao.insert(book);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(16);
        book.setType("测试2222222222222222222222");
        book.setName("测试1111111");
        book.setDescription("测试1111111");
        bookDao.updateById(book);
    }

    @Test
    void testDelete(){
        bookDao.deleteById(15);
    }

    @Test
    void testGetAll() {
        System.out.println(bookDao.selectList(null));
    }

    @Test
    void testGetPage() {
        IPage page = new Page(1, 5);
        bookDao.selectPage(page, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());

    }

    //按条件查询
    @Test
    void testGetBy() {
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name", "spring");
        bookDao.selectList(qw);
    }

    @Test
    void testGetBy2() {
        String name = "spring";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        //if (name!=null) lqw.like(Book::getName,name);
        lqw.like(name != null, Book::getName, name);
        bookDao.selectList(lqw);
    }
}
