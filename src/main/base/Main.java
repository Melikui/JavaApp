import java.util.Arrays;

import static algorithm.Sort.bubbleSort;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 6, 3, 63, 32, 34, 43, 35};
        bubbleSort(arr);
        System.out.println("排序后："+ Arrays.toString(arr));
    }

}

