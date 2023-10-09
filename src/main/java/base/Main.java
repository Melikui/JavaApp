package base;

import base.algorithm.Search;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6};
        Search search = new Search();
        System.out.println(search.binarySearch(arr, 3));
    }
}
