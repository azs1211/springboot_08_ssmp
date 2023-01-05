package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.utils.Result;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author ZiShao
 * @create 2022-12-30 22:00
 **/
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService iBookService;

    @GetMapping
    public Result getAll() {
        return new Result(true, iBookService.list(null));
    }

    @PostMapping
    public Result save(@RequestBody Book book) throws Exception {
//        Result result = new Result();
//        boolean flag = iBookService.save(book);
//        result.setFlag(flag);
//        return result;
        if (book.getName().equals("123")) {
            throw new IOException();
        }
        boolean flag = iBookService.save(book);
        //这一行和上方一样
        return new Result(flag, flag ? "添加成功^_^" : "添加失败-_-");
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        return new Result(iBookService.updateById(book));
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id) {
        return new Result(iBookService.removeById(id));
    }

    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id) {
        return new Result(true, iBookService.getById(id));
    }

//    @GetMapping("{currentPage}/{pageSize}")
//    public Result getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
//        IPage<Book> page = iBookService.getPage(currentPage, pageSize);
//        //如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
//        if (currentPage > page.getPages()) {
//            page = iBookService.getPage((int) page.getPages(), pageSize);
//        }
//        return new Result(true, page);
//
//    }

    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {
        IPage<Book> page = iBookService.getPage(currentPage, pageSize,book);
        //如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage > page.getPages()) {
            page = iBookService.getPage((int) page.getPages(), pageSize,book);
        }
        return new Result(true, page);

    }
}
