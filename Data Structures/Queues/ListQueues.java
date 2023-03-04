package Queues;

import java.util.AbstractQueue;
import java.util.Queue;

public class ListQueues<E> extends AbstractQueue<E> implements Queue<E> {
    private class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E dataItem) {
            this.data = dataItem;
            this.next = null;
        }

        public Node(E dataItem, Node<E> nodeRef) {
            this.data = dataItem;
            this.next = nodeRef;
        }
    }

    private Node<E> front;
    private Node<E> rear;
    private int size;

    @Override
    public E peek() {
        if (this.front == null) {
            return null;
        }
        return this.front.data;
    }

    @Override
    public boolean offer(E item) {
        if (item == null) {
            return false;
        }
        if (this.front == null) {
            this.rear = new Node<>(item);
            this.front = this.rear;
        } else {
            this.rear.next = new Node<>(item);
            this.rear = this.rear.next;
        }
        this.size++;
        return true;
    }

    @Override
    public E poll() {
        E item = peek();
        if (item == null) {
            return null;
        }
        if (this.size == 1) {
            this.front = null;
            this.rear = null;
        } else {
            this.front = this.front.next;
        }
        this.size--;
        return item;
    }

    @Override
    public int size() {
        return this.size;
    }

    public Iterable<E> iterator() {
        return null;
    }
}
