package algorithm.squence;

/**
 * 线性表之顺序表
 *
 * @param <T>
 */
public class SequenceList<T> {
    // 顺序表中一维数组的初始长度
    final int SIZE = 10;
    // 存储元素的数组对象
    private T[] listArray;
    // 保存顺序表的当前长度
    private int length;

    // 构造一个空的线性表
    @SuppressWarnings("unchecked")
    public SequenceList() {
        // 线性表初始为空
        length = 0;
        listArray = (T[]) new Object[SIZE];
    }

    @SuppressWarnings("unchecked")
    public SequenceList(int size) {
        if (size <= 0) {
            System.out.println("初始化长度必须大于0");
            System.exit(1);
        }
        // 线性表初始为空
        length = 0;
        listArray = (T[]) new Object[size];
    }

    // 在线性表中插入一个新元素
    @SuppressWarnings("unchecked")
    public boolean add(T obj, int pos) {
        if (pos < 1 || pos > length + 1) {
            System.out.println("pos值不合法");
            return false;
        }
        // 容量不够自动扩容 length*2
        if (length == listArray.length) {
            T[] p = (T[]) new Object[length * 2];
            System.arraycopy(listArray, 0, p, 0, length);
            listArray = p;
        }
        for (int i = length; i >= pos; i--) {
            listArray[i] = listArray[i - 1];
        }
        listArray[pos - 1] = obj;
        length++;
        return true;
    }

    // 删除线性表中某个元素
    public T remove(int pos) {
        if (isEmpty()) {
            System.out.println("顺序表为空，无法执行删除操作");
            return null;
        } else {
            if (pos < 1 || pos > length) {
                System.out.println("pos值不合法");
                return null;
            }
            T x = listArray[pos - 1];
            for (int i = pos; i <= length; i++) {
                listArray[i - 1] = listArray[i];
            }
            length--;
            return x;
        }
    }

    // 在线性表查找一个元素
    public int find(T obj) {
        if (isEmpty()) {
            System.out.println("顺序表为空");
            return -1;
        } else {
            for (int i = 0; i < length; i++) {
                if (listArray[i].equals(obj)) {
                    return i + 1;
                }
            }
            return -1;
        }
    }

    // 获取线性表中一个元素
    public T value(int pos) {
        if (isEmpty()) {
            System.out.println("顺序表为空");
            return null;
        } else {
            if (pos < 1 || pos > length) {
                System.out.println("pos值不合法");
                return null;
            }
            return listArray[pos - 1];
        }
    }

    // 更新线性表中某个元素
    public boolean modify(T obj, int pos) {
        if (isEmpty()) {
            System.out.println("顺序表为空");
            return false;
        } else {
            if (pos < 1 || pos > length) {
                System.out.println("error");
                return false;
            }
            listArray[pos - 1] = obj;
            return true;
        }
    }

    // 判空
    public boolean isEmpty() {
        return length == 0;
    }

    // 求线性表中数据元素的个数
    public int size() {
        return length;
    }

    // 依次访问栈中每个元素并输出
    public void nextOrder() {
        for (int i = 0; i < length; i++) {
            System.out.println(listArray[i]);
        }
    }

    // 销毁一个已经存在的线性表
    public void clear() {
        length = 0;
    }


    /**
     * 测试
     */
    public static void main(String[] args) {
        SequenceList<Integer> L = new SequenceList<>();
        int status, e, i;
        int[] a = {23, 56, 12, 49, 35};
        for (i = 0; i < a.length; i++) {
            // 将数组中个元素插入到顺序表中
            L.add(a[i], i + 1);
        }
        System.out.println("顺序表中的数据元素为：");
        L.nextOrder();
        L.add(30, 4);
        System.out.println("执行插入操作后顺序表中的数据元素为：");
        L.nextOrder();
        e = L.remove(5);
        System.out.println("执行删除操作后顺序表中的数据元素为：");
        L.nextOrder();
        // 在顺序表L中查找元素12的位序
        i = L.find(12);
        System.out.println("元素12在线性表中的位序为:" + i);
    }
}