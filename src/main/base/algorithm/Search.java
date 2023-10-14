package algorithm;

import java.util.Arrays;

public class Search {
    /**
     * 无序列表排序
     *
     * @param arr 列表
     * @param item 待搜索内容
     * @return boolean
     */
    public static boolean sequentialSearch(int[] arr, int item) {
        for (int i : arr) {
            if (i == item) {
                return true;
            }
        }
        return false;
    }

    /**
     * 有序列表排序
     *
     * @param arr 列表
     * @param item 待搜索内容
     * @return boolean
     */
    public static boolean orderedSequentialSearch(int[] arr, int item) {
        // 先对列表进行排序
        // Arrays.sort(arr);
        for (int i : arr) {
            if (i == item) {
                return true;
            } else {
                if (i > item) {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * 二分查找/折半查找
     *
     * @param arr 列表
     * @param item 待搜索内容
     * @return boolean
     */
    public static boolean binarySearch(int[] arr, int item) {
        // 先对列表进行排序
        // Arrays.sort(arr);
        // 1.定义两个变量记录要查找的范围
        int left = 0;
        int right = arr.length - 1;
        boolean found = false;
        // 2.利用循环不断的去找要查找的数据
        while (left <= right && !found) {
            // 3.找到min和max的中间位置
            int mid = (left + right) / 2;
            // 4.拿着mid指向的元素跟要查找的元素进行比较
            if (arr[mid] == item) {
                return true;
            } else {
                if (item < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return found;
    }
}

