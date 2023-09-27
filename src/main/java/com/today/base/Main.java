package com.today.base;

import com.today.base.algorithm.Search;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Search s = new Search();
        int[] list = {1, 51, 2, 6, 23, 64, 34};
        boolean result = s.binarySearch(list, 61);
        System.out.println(result);
    }
}

