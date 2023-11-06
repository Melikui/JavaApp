package algorithm.tree;

public class Node<T> {
    // 左结点
    public Node<T> left;
    // 数据
    private final T data;
    // 右结点
    public Node<T> right;


    public Node() {
        this.data = null;
        this.left = null;
        this.right = null;
    }

    public Node(T x) {
        this.data = x;
        this.left = null;
        this.right = null;
    }
}
