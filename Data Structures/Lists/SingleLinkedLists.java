package Lists;

public class SingleLinkedLists<E> {
    private Node<E> head;
    private int size;

    public static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    public SingleLinkedLists() {
        this.head = null;
        this.size = 0;
    }

    public void addFirst(E item) {
        this.head = new Node<>(item, this.head);
        this.size++;
    }

    public void add(E item, int index) {
        if (index <  0 || index > this.size) {
            throw new IllegalArgumentException("Add: Index Out of Bounds");
        }
        if (index == 0) {
            addFirst(item);
        } else {
            Node<E> current = this.head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = new Node<>(item, current.next);
            size++;
        }
    }

    public E getAt(int index) {
        if (index <  0 || index > this.size) {
            throw new IllegalArgumentException("Add: Index Out of Bounds");
        }
        Node<E> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    private void removeFirst() {
        if (this.head == null) {
            throw new IllegalArgumentException("Remove: List is empty");
        } else {
            this.head = this.head.next;
            this.size--;
        }
    }

    public void remove(int index) {
        if (index <  0 || index > this.size) {
            throw new IllegalArgumentException("Add: Index Out of Bounds");
        }
        if (index == 0) {
            removeFirst();
        } else {
            Node<E> current = this.head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        }
    }
}
