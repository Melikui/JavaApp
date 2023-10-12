package com.today.App.util;

import lombok.Data;

/**
 * 统一API响应结果封装
 */

@Data
public class Result {
    // 1,成功，0,失败
    private int code;
    // 提示信息
    private String msg;
    // 数据 data
    private Object data;

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result ok() {
        return new Result(1, "success", null);
    }

    public static Result ok(String msg) {
        return new Result(1, msg, null);
    }

    public static Result ok(Object data) {
        return new Result(1, "success", data);
    }

    public static Result error(String msg) {
        return new Result(0, msg, null);
    }
}