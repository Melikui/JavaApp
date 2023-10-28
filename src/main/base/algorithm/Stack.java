package algorithm;

public class Stack {
    public static void main(String[] args) {
        SequenceStack<Integer> ss = new SequenceStack<>(10);
        ss.push(1);
        ss.push(2);
        ss.push(3);
        ss.push(4);
        ss.nextOrder();
        System.out.println("top---" + ss.peek());
        System.out.println("pop---" + ss.pop());
        System.out.println("top---" + ss.peek());
    }
}

/**
 * 顺序栈
 *
 * @param <T>
 */
class SequenceStack<T> {
    final int MaxSize = 10;
    private T[] stackArray;
    private int top;

    @SuppressWarnings("unchecked")
    public SequenceStack() {
        top = -1;
        stackArray = (T[]) new Object[MaxSize];
    }

    @SuppressWarnings("unchecked")
    public SequenceStack(int n) {
        if (n <= 0) {
            System.out.println("数组长度要大于0，否则退出程序运行！");
            System.exit(1);
        }
        top = -1;
        stackArray = (T[]) new Object[n];
    }

    // 在栈顶位置插入一个新元素
    @SuppressWarnings("unchecked")
    public void push(T obj) {
        // 判断栈是否满了，栈满时，自动扩容。
        if (top == stackArray.length - 1) {
            T[] p = (T[]) new Object[top * 2 + 2];
            for (int i = 0; i <= top; i++) {
                System.out.println("---" + stackArray[i]);
                p[i] = stackArray[i];
            }
            // 数组拷贝相当于 System.arraycopy(stackArray, 0, p, 0, top + 1);
            stackArray = p;
        }
        top++;
        stackArray[top] = obj;
    }

    // 删除栈顶元素
    public T pop() {
        if (top == -1) {
            System.out.println("数据栈已空");
            return null;
        }
        top--;
        return stackArray[top + 1];
    }

    // 取栈顶数据元素
    public T peek() {
        if (top == -1) {
            System.out.println("数据栈已空");
            return null;
        }
        return stackArray[top];
    }

    // 判断当前栈是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    // 求出栈中数据元素的个数
    public int size() {
        return top + 1;
    }

    // 依次访问栈中每个元素并输出
    public void nextOrder() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stackArray[i]);
        }
    }

    // 销毁一个已存在的栈
    public void clear() {
        top = -1;
    }
}


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
    public T getHead() {
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

