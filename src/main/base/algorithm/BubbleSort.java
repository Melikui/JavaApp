package algorithm;

public class BubbleSort {
    /**
     * 对数组arr中的元素进行排序
     */
    public static void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (compare(arr[j], arr[j + 1])) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 比较v元素是否大于w元素
     */
    private static boolean compare(int v, int w) {
        return v > w;
    }

    /**
     * 数组元素i和j交换位置
     */
    private static void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
