package com.itheima.domain;

import lombok.Data;

/**
 * @author ZiShao
 * @create 2022-12-30 16:13
 **/
@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
