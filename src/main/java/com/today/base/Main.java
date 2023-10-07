package com.today.base;

import com.today.base.plugins.Redis;

public class Main {
    public static void main(String[] args) throws Exception {
        Redis redis = new Redis();
        redis.set("say","hello world");
        System.out.println(redis.get("say"));
    }
}

