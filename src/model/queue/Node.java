package model.queue;

public class Node<T> {
    public T key;
    public Node next;

    public Node(T key) {
        this.key = key;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", next=" + next +
                '}';
    }
}
