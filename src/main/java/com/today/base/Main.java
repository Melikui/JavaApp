package com.today.base;

public class Main {
    public static void main(String[] args) {
        int result = recursion(10);
        System.out.println("计算结果: " + result);
    }

    // 计算数的阶乘
    public static int recursion(int num) {
        // System.out.println(num);
        return num == 1 ? num : num * recursion(num - 1);
    }
}

