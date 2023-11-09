package com.vvtcp.App.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一API响应结果封装
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JSONResult {
    // 1,成功，0,失败
    private int code;
    // 提示信息
    private String msg;
    // 数据 data
    private Object data;

    public static JSONResult ok() {
        return new JSONResult(1, "success", null);
    }

    public static JSONResult ok(String msg) {
        return new JSONResult(1, msg, null);
    }

    public static JSONResult ok(Object data) {
        return new JSONResult(1, "success", data);
    }

    public static JSONResult error(String msg) {
        return new JSONResult(0, msg, null);
    }
}