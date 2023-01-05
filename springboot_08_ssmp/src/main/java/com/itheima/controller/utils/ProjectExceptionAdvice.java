package com.itheima.controller.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author ZiShao
 * @create 2023-01-03 18:24
 **/
//作为SpringMVC的异常处理器，其它层的异常都抛到表现层，因此只需处理表现层
//@ControllerAdvice
@RestControllerAdvice
public class ProjectExceptionAdvice {
    //拦截所有的异常信息
    @ExceptionHandler
    public Result doException(Exception ex){
        /**
         * 记录日志
         * 通知运维
         * 通知开发
         */

        ex.printStackTrace();
        return new Result("服务器故障，请稍后再试！");
    }
}
