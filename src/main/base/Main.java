import example.MyCallable;
import example.MyRunnable;
import example.MyThread;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Main {
    // -----------------------------------
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // MyThread mt1 = new MyThread();
        // MyThread mt2 = new MyThread();
        // mt1.start();
        // mt2.start();
        // mt1.setName("***");
        // mt2.setName("###");

        MyRunnable mr = new MyRunnable();
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);
        t1.setName("***");
        t2.setName("###");
        t1.start();
        t2.start();



        // MyCallable mc = new MyCallable();
        // FutureTask<Integer> ft = new FutureTask<>(mc);
        // Thread t1 = new Thread(ft);
        // t1.start();
        // Integer result = ft.get();
        // System.out.println(result);

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
