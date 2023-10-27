import java.util.Arrays;

public class Main {
    // -----------------------------------
    public static void main(String[] args) {
        int[] arr = {1, 33, 25, 8, 16, 23, 53, 73, 21};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
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
