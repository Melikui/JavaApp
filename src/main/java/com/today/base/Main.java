package com.today.base;

public class Main {
    public static void main(String[] args) {
        String phoneNumber = "13135519763";
        String start = phoneNumber.substring(0, 3);
        String end = phoneNumber.substring(7);
        String result = start + "*".repeat(4) + end;
        System.out.println(result);
    }
}

