package model.queue;

public abstract class LinkedListQueue<T> {
    public Node<T> head = null;
    public Node<T> tail = null;

    public LinkedListQueue() {
    }

    public void enQueue(T key) {
        Node<T> temp = new Node(key);
        if (this.tail == null) {
            this.head = this.tail = temp;
            return;
        }
        this.tail.next = temp;
        this.tail = temp;
    }

    public Node<T> deQueue() {
        if (this.head == null) {
            return null;
        }
        Node<T> temp = this.head;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        }
        return temp;
    }

    @Override
    public String toString() {
        return "LinkedListQueue{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
}
