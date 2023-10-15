import algorithm.Sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,32,6,31,64,23,13,9};
        Sort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}

