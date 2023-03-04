package Stack;

import java.util.NoSuchElementException;

public class LinkedStack<E> implements StackInt<E> {
    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node(E dataItem) {
            this.data = dataItem;
            this.next = null;
        }
        private Node(E dataItem, Node<E> nodeRef) {
            this.data = dataItem;
            this.next = nodeRef;
        }
    }

    private Node<E> topOfStackRef;

    public LinkedStack() {
        this.topOfStackRef = null;
    }

    public LinkedStack(E[] data) {
        this.topOfStackRef = null;
        for (E item: data) {
            push(item);
        }
    }

    @Override
    public E push(E obj) {
        this.topOfStackRef = new Node<E>(obj, this.topOfStackRef);
        return obj;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E obj = this.topOfStackRef.data;
        this.topOfStackRef = this.topOfStackRef.next;
        return obj;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node<E> current = this.topOfStackRef;
        s.append("[top] <- ");
        while (current != null) {
            s.append(current.data.toString() + " <-");
            current = current.next;
        }
        s.append("[bottom]");
        return s.toString();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.topOfStackRef.data;
    }

    @Override
    public boolean isEmpty() {
        return this.topOfStackRef == null;
    }
}
