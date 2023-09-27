package com.today.base;

public class Main {
    public static void main(String[] args) {
        for (int x = 1; x < 100; x++) {
            for (int y = 1; y < 100; y++) {
                for (int z = 1; z < 100; z++) {
                    if (x < y && (x * x + y * y == z * z)) {
                        System.out.println(x + "," + y + "," + z);
                    }
                }
            }
        }
    }
}


