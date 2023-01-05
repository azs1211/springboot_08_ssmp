package com.itheima.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ZiShao
 * @create 2022-12-30 16:24
 **/
@Mapper
public interface BookDao extends BaseMapper<Book> {
}
