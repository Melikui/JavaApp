package algorithm;

/**
 * 链栈
 *
 * @param <T>
 */
class LinkStack<T> {
    // 栈顶指针
    private Node<T> top;
    // 存储栈的长度
    private int length;

    // 构造一个空的栈
    public LinkStack() {
        length = 0;
        top = null;
    }

    // 入栈
    public void push(T obj) {
        top = new Node<T>(obj, top);
        length++;
    }

    // 出栈
    public T pop() {
        if (top == null) {
            System.out.println("栈已空，无法删除元素！");
            return null;
        }
        T x = top.data;
        top = top.next;
        length--;
        return x;
    }

    // 取栈顶数据元素
    public T peek() {
        if (top == null) {
            System.out.println("栈已空，无法读取元素！");
            return null;
        }
        return top.data;
    }

    // 求出栈中数据元素的个数
    public int size() {
        return length;
    }

    // 判断当前栈是否为空
    public boolean isEmpty() {
        return top == null;
    }

    // 依次访问栈中每个元素并输出
    public void nextOrder() {
        Node<T> p = top;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
    }

    // 销毁一个已存在的栈
    public void clear() {
        top = null;
    }
}
