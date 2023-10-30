package algorithm.squence;

public class Node<T> {
    T data;
    Node<T> next;

    public Node(Node<T> n) {
        next = n;
    }

    public Node(T obj, Node<T> n) {
        data = obj;
        next = n;
    }

    public T getData() {
        System.out.println("data--"+data);
        return data;
    }

    public Node<T> getNext() {
        System.out.println("next--"+next);
        return next;
    }
}
