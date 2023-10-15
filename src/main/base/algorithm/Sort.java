package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 1. 冒泡排序（Bubble Sort）
 * 2. 选择排序（Selection Sort）
 * 3. 插入排序（Insertion Sort）
 * 4. 快速排序（Quick Sort）
 * 5. 归并排序（Merge Sort）
 * 6. 堆排序（Heap Sort）
 * 7. 希尔排序（Shell Sort）
 * 8. 计数排序（Counting Sort）
 * 9. 桶排序（Bucket Sort）
 * 10.基数排序（Radix Sort）
 */
public class Sort {
    /**
     * 1. 冒泡排序（Bubble Sort）
     *
     * @param arr: 列表
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换相邻元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 2. 选择排序（Selection Sort）
     *
     * @param arr: 列表
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * 3. 插入排序（Insertion Sort）
     *
     * @param arr: 列表
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            // 将大于key的元素向后移动
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * 4. 快速排序（Quick Sort）
     * quickSort(arr, 0, arr.length - 1);
     *
     * @param arr:  列表
     * @param low:  左侧索引
     * @param high: 右侧索引
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 5. 归并排序（Merge Sort）
     * mergeSort(arr, 0, arr.length - 1);
     *
     * @param arr:   列表
     * @param left:  左侧索引
     * @param right: 右侧索引
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr, left, L, 0, n1);
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    /**
     * 6. 堆排序（Heap Sort）
     *
     * @param arr: 列表
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    /**
     * 7. 希尔排序（Shell Sort）
     *
     * @param arr: 列表
     */
    public static void shellSort(int[] arr) {
        int n = arr.length;
        int gap = n / 2;
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
            gap /= 2;
        }
    }

    /**
     * 8. 计数排序（Counting Sort）
     *
     * @param arr: 列表
     */
    public static void countingSort(int[] arr) {
        int len = arr.length;
        // 确定计数数组的大小
        int max = Arrays.stream(arr).max().orElse(0) + 1;
        int[] count = new int[max];
        int[] output = new int[len];
        // 统计每个元素的出现次数
        for (int j : arr) {
            count[j]++;
        }
        // 根据计数数组构建排序结果
        int index = 0;
        for (int i = 0; i < max; i++) {
            while (count[i] > 0) {
                output[index++] = i;
                count[i]--;
            }
        }
        // 将排序结果复制回原数组
        System.arraycopy(output, 0, arr, 0, len);
    }

    /**
     * 9. 桶排序（Bucket Sort）
     *
     * @param arr:        列表
     * @param bucketSize: 数量
     */
    public static void bucketSort(int[] arr, int bucketSize) {
        if (arr.length < 2) {
            return;
        }
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int k : arr) {
            if (k < minValue) {
                minValue = k;
            } else if (k > maxValue) {
                maxValue = k;
            }
        }
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int k : arr) {
            bucketArr.get((k - minValue) / bucketSize).add(k);
        }
        for (int i = 0; i < bucketCount; i++) {
            Collections.sort(bucketArr.get(i));
            resultArr.addAll(bucketArr.get(i));
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = resultArr.get(i);
        }
    }

    /**
     * 10.基数排序（Radix Sort）
     *
     * @param arr: 列表
     */
    public static void radixSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int maxValue = getMaxValue(arr);
        int exp = 1;
        int[] temp = new int[arr.length];
        while (maxValue / exp > 0) {
            int[] count = new int[10];
            // 统计每个桶中的元素个数
            for (int j : arr) {
                count[(j / exp) % 10]++;
            }
            // 累加每个桶中元素的个数，得到每个桶的结束位置
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }
            // 从后往前遍历原数组，根据当前位的值放入相应的桶中
            for (int i = arr.length - 1; i >= 0; i--) {
                temp[--count[(arr[i] / exp) % 10]] = arr[i];
            }
            // 将排好序的桶中的元素复制回原数组
            System.arraycopy(temp, 0, arr, 0, arr.length);
            // 当前位乘以10，进入下一轮排序
            exp *= 10;
        }
    }

    private static int getMaxValue(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
