package algorithm;

/**
 * 搜索算法是计算机科学中用于在给定数据集中查找特定元素或确定是否存在某个元素的算法。以下是几种常见的搜索算法：
 * 顺序搜索：逐个遍历数据集中的元素，直到找到目标元素或遍历完整个数据集。
 * 二分搜索：对于有序数组，通过比较目标值与数组中间元素的大小，将搜索范围缩小一半，然后重复此过程直到找到目标元素或确定不存在。
 * 哈希表搜索：使用哈希表将元素与其对应的位置映射起来，以快速查找特定元素。
 * 二叉搜索树：将元素按照一定的排序方式组织成二叉树结构，通过比较目标值与当前节点的值，逐步向左或向右子树搜索。
 * 广度优先搜索（BFS）：从起始节点开始，逐层遍历搜索，直到找到目标节点或遍历完整个图。常用于图的搜索问题。
 * 深度优先搜索（DFS）：从起始节点开始，递归地探索每个分支直到找到目标节点或遍历完整个图。也通常用于图的搜索问题。
 * 这些搜索算法在不同的场景和数据结构中发挥作用，根据具体问题的需求，选择适合的搜索算法可以提高搜索效率。
 */
public class Search {
    /**
     * 无序列表排序
     *
     * @param arr    列表
     * @param target 待搜索内容
     * @return boolean
     */
    public static boolean sequentialSearch(int[] arr, int target) {
        for (int i : arr) {
            if (i == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * 有序列表排序
     *
     * @param arr    列表
     * @param target 待搜索内容
     * @return boolean
     */
    public static boolean orderedSequentialSearch(int[] arr, int target) {
        // 先对列表进行排序
        // Arrays.sort(arr);
        for (int i : arr) {
            if (i == target) {
                return true;
            } else {
                if (i > target) {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * 二分查找/折半查找
     *
     * @param arr    列表
     * @param target 待搜索内容
     * @return boolean
     */
    public static int binarySearch(int[] arr, int target) {
        // 先对列表进行排序
        // Arrays.sort(arr);
        // 1.定义两个变量记录要查找的范围
        int left = 0;
        int right = arr.length - 1;
        // 2.利用循环不断的去找要查找的数据
        while (left <= right) {
            // 3.找到 min 和 max 的中间位置
            // int mid = (left + right) / 2;
            int mid = (left + right) >>> 2;
            // 4.拿着mid指向的元素跟要查找的元素进行比较
            if (arr[mid] == target) {
                System.out.println("查找元素下标为:" + mid);
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

