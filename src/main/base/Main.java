import algorithm.Sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 6, 3, 63, 32, 34, 43, 35};
        Sort.quickSort(arr,0,7);
        System.out.println("排序后："+ Arrays.toString(arr));
    }

}

