package com.today.base;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int rand_int1 = rand.nextInt(1000);
        System.out.println("Random Integers: " + rand_int1);
    }
}

