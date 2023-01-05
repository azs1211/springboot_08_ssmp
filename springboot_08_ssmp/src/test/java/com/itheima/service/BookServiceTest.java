package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ZiShao
 * @create 2022-12-30 20:20
 **/
@SpringBootTest
public class BookServiceTest {
    @Autowired
    private IBookService iBookService;

    @Test
    void getById() {
        System.out.println(iBookService.getById(1));
//        bookService.getById(1);
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("测试1111111");
        book.setName("测试1111111");
        book.setDescription("测试1111111");
        iBookService.save(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(17);
        book.setType("测试2222222222222222222222");
        book.setName("测试1111111asdfghj");
        book.setDescription("测试1111111");
        iBookService.updateById(book);
    }

    @Test
    void testDelete() {
        iBookService.removeById(16);
    }

    @Test
    void testGetAll() {
        System.out.println(iBookService.list());
    }

    @Test
    void testGetPage() {
        IPage<Book> page = new Page<>(2,5);
        iBookService.page(page);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());

    }


}
