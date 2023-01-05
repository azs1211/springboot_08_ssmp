package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ZiShao
 * @create 2022-12-30 22:00
 **/
//@RestController
@RequestMapping("/books")
public class BookController2 {
    @Autowired
    private IBookService iBookService;

    @GetMapping
    public List<Book> getAll() {
        return iBookService.list(null);
    }

    @PostMapping
    public boolean save(@RequestBody Book book) {
        return iBookService.save(book);
    }

    @PutMapping
    public boolean update(@RequestBody Book book) {
        return iBookService.updateById(book);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Integer id) {
        return iBookService.removeById(id);
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id) {
        return iBookService.getById(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        return iBookService.getPage(currentPage, pageSize, null);
    }
}
