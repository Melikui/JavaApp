package com.today.App.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 这里的 return 信息会返回给前端
     */
    @ExceptionHandler(Exception.class) // 捕获所有异常
    public JSONResult handleException(Exception e) {
        log.error("⚠️ 自定义异常信息：{}", e.getMessage());
        return JSONResult.error(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class) // 捕获运行时异常
    public JSONResult handleMyException(RuntimeException e) {
        log.error("运行时异常信息：{}", e.getMessage());
        return JSONResult.error(e.getMessage());
    }

    @ExceptionHandler(ArithmeticException.class) // 捕获算术异常
    public JSONResult handleMyException(ArithmeticException e) {
        log.error("算术异常信息：{}", e.getMessage());
        return JSONResult.error(e.getMessage());
    }
}
