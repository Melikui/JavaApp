import algorithm.squence.SequenceList;

public class Main {
    // -----------------------------------
    public static void main(String[] args) {
        SequenceList<Integer> L = new SequenceList<>();
        int status, e, i;
        int[] a = {23, 56, 12, 49, 35};
        for (i = 0; i < a.length; i++) {
            L.add(a[i], i + 1);   //将数组中个元素插入到顺序表中
        }
        System.out.println("顺序表中的数据元素为：");
        L.nextOrder();
        L.add(30, 4);
        System.out.println("执行插入操作后顺序表中的数据元素为：");
        L.nextOrder();
        e = L.remove(5);
        System.out.println("执行删除操作后顺序表中的数据元素为：");
        L.nextOrder();
        i = L.find(12);        //在顺序表L中查找元素12的位序
        System.out.println("元素12在线性表中的位序为:" + i);
    }

    // -----------------------------------

    /**
     * 希尔排序
     */
    public static void shellSort(int[] arr) {
        int len = arr.length;
        int h = 1;
        while (h < len / 2) {
            h = 2 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (arr[j - h] > arr[j]) {
                        int temp = arr[j - h];
                        arr[j - h] = arr[j];
                        arr[j] = temp;
                    } else {
                        break;
                    }
                }
            }
            h = h / 2;
        }

    }

    /**
     * 插入排序
     */
    public static void insertionSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }

        }
    }

    /**
     * 选择排序
     */
    public static void selectionSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }
    }

    /**
     * 二分法查找
     */
    public static int binarySearch(int[] arr, int target) {
        int left = arr[0];
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 2;
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
