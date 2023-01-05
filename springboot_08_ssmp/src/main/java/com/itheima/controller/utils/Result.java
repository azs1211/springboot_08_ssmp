package com.itheima.controller.utils;

import lombok.Data;

/**
 * @author ZiShao
 * @create 2022-12-31 11:58
 **/
@Data
public class Result {
    private boolean flag;
    private Object data;
    private String msg;

    public Result() {

    }

    public Result(boolean flag) {
        this.flag = flag;
    }

    public Result(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public Result(boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    /**
     * 都已经异常了，flag一定是false，data的返回值一定是null了，就不用定义data了
     *
     * @param msg
     */
    public Result(String msg) {
        this.flag = false;
        this.msg = msg;
    }
}
