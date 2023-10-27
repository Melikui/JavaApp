import example.MyThread;

import java.util.Arrays;

public class Main {
    // -----------------------------------
    public static void main(String[] args) {
        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();
        mt1.start();
        mt2.start();
        mt1.setName("***");
        mt2.setName("###");
    }
    // -----------------------------------

    /**
     * 二分法查找
     */
    public static int binarySearch(int[] arr, int target) {
        int left = arr[0];
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else {
                if (target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
