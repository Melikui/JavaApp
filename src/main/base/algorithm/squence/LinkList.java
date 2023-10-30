package algorithm.squence;

public class LinkList<T> {
    // 头指针
    private final Node<T> head;
    // 单链表的长度
    private int length;

    // 构造一个空的链表
    public LinkList() {
        length = 0;
        head = new Node<T>(null);
    }

    // 获取链表头结点地址
    public Node<T> getHead() {
        System.out.println("head--" + head);
        return head;
    }

    // 在链表中插入一个新元素
    public boolean add(T obj, int pos) {
        if (pos < 1 || pos > length + 1) {
            System.out.println("pos值不合法");
        }
        int num = 1;
        Node<T> p = head, q = head.next;
        while (num < pos) {
            p = q;
            q = q.next;
            num++;
        }
        p.next = new Node<T>(obj, q);
        length++;
        return true;
    }

    // 删除链表中某个元素
    public T remove(int pos) {
        if (isEmpty()) {
            System.out.println("链表为空表");
            return null;
        } else {
            if (pos < 1 || pos > length + 1) {
                System.out.println("pos值不合法");
                return null;
            }
            int num = 1;
            Node<T> p = head, q = head.next;
            while (num < pos) {
                p = q;
                q = q.next;
                num++;
            }
            p.next = q.next;
            length--;
            return q.data;
        }
    }

    // 获取链表中一个元素
    public T value(int pos) {
        if (isEmpty()) {
            System.out.println("链表为空表");
            return null;
        } else {
            if (pos < 1 || pos > length + 1) {
                System.out.println("pos值不合法");
                return null;
            }
            int num = 1;
            Node<T> q = head.next;
            while (num < pos) {
                q = q.next;
                num++;
            }
            return q.data;
        }
    }

    // 在链表查找一个元素
    public int find(T obj) {
        if (isEmpty()) {
            System.out.println("链表为空表");
            return -1;
        }
        int num = 1;
        // p引用的是头结点之后的结点
        Node<T> p = head.next;
        // 单链表的判空条件
        while (p != null) {
            // equals判断两个对象值是否相等
            if (!p.data.equals(obj)) {
                p = p.next;
                num++;
            } else break;
        }
        if (p == null) return -1;
        return num;
    }

    // 更新链表中某个元素
    public boolean modify(T obj, int pos) {
        if (isEmpty()) {
            System.out.println("链表为空表");
            return false;
        } else {
            if ((pos < 1 || pos > length + 1)) {
                System.out.println("pos值不合法");
                return false;
            }
            int num = 1;
            Node<T> q = head.next;
            while (num < pos) {
                q = q.next;
                num++;
            }
            q.data = obj;
            return true;
        }
    }

    // 判空
    public boolean isEmpty() {
        return length == 0;
    }

    // 求链表中数据元素的个数
    public int size() {
        return length;
    }

    // 依次访问链表中每个元素并输出
    public void nextOrder() {
        Node<T> p = head.next;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
    }

    // 销毁一个已经存在的链表
    public void clear() {
        length = 0;
        head.next = null;
    }

    public static void main(String[] args) {
        LinkList<Integer> L = new LinkList<Integer>();
        int i;
        int[] arr = {23, 56, 12, 49, 35};
        for (i = 0; i < arr.length; i++) {
            // 将数组中各元素插入到单链表中
            L.add(arr[i], i + 1);
        }
        System.out.println("单链表中的数据元素为：");
        L.nextOrder();
        L.add(30, 4);
        System.out.println("执行插入操作后单链表中的数据元素为：");
        L.nextOrder();
        int res = L.remove(5);
        System.out.print("执行删除操作后单链表中的数据元素为：" + res + "\n");
        L.nextOrder();
        // 在单链表L中查找元素12的位序
        i = L.find(12);
        System.out.println("元素12在单链表中的位序为:" + i);
    }
}
