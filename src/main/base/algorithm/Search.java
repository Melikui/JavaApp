package algorithm;

import java.util.Arrays;

public class Search {
    /**
     * 无序列表排序
     *
     * @param list 列表
     * @param item 待搜索内容
     * @return boolean
     */
    public boolean sequentialSearch(int[] list, int item) {
        for (int i : list) {
            if (i == item) {
                return true;
            }
        }
        return false;
    }

    /**
     * 有序列表排序
     *
     * @param list 列表
     * @param item 待搜索内容
     * @return boolean
     */
    public boolean orderedSequentialSearch(int[] list, int item) {
        // 先对列表进行排序
        Arrays.sort(list);
        for (int i : list) {
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
     * @param list 列表
     * @param item 待搜索内容
     * @return boolean
     */
    public boolean binarySearch(int[] list, int item) {
        // 1.定义两个变量记录要查找的范围
        int first = 0;
        int last = list.length - 1;
        boolean found = false;
        // 2.利用循环不断的去找要查找的数据
        while (first <= last && !found) {
            // 3.找到min和max的中间位置
            int mid = (first + last) / 2;
            // 4.拿着mid指向的元素跟要查找的元素进行比较
            if (list[mid] == item) {
                return true;
            } else {
                if (item < list[mid]) {
                    last = mid - 1;
                } else {
                    first = mid + 1;
                }
            }
        }
        return found;
    }
}

