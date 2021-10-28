package datastructures.arrays.theory;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList() {
        this(0);
    }

    private DoublyLinkedList(int size) {
        this.size = size;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0 && head == null && tail == null;
    }

    public void clear() {
        Node<T> current = head;
        while (current != null) {
            Node<T> next = current.next;
            current.previous = current.next = null;
            current.node = null;
            current = next;
        }
        head = tail = current = null;
        size = 0;
    }

    public void add(T element) {
        addLast(element);
    }

    public void addLast(T element) {
        if (isEmpty()) {
            head = tail = new Node<>(element, null, null);
        } else {
            tail.next = new Node<>(element, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public void addFirst(T element) {
        if (isEmpty()) {
            head = tail = new Node<>(element, null, null);
        } else {
            head.previous = new Node<>(element, null, head);
            head = head.previous;
        }
        size++;
    }

    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        return head.node;
    }

    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Empty List");
        return tail.node;
    }

    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("Empty List");
        T data = head.node;
        head = head.next;
        --size;
        if (isEmpty()) tail = null;
        else head.previous = null;
        return data;
    }

    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Empty List");
        T data = tail.node;
        tail = tail.previous;
        --size;
        if (isEmpty()) head = null;
        else tail.next = null;
        return data;
    }


    private T remove(Node<T> node) {
        if (node.previous == null) return removeFirst();
        if (node.next == null) return removeLast();
        node.next.previous = node.previous;
        node.previous.next = node.next;

        T data = node.node;
        node.node = null;
        node = node.previous = node.next = null;

        --size;

        return data;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException();
        int i;
        Node<T> current;
        if (index < size / 2) {
            current = head;
            for (i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (i = size - 1; i > index; i--) {
                current = current.previous;
            }
        }
        return remove(current);
    }

    public boolean remove(T data) {
        Node<T> current;
        for (current = head; current != null; current = current.next) {
            if (current.node.equals(data)) {
                remove(current);
                return true;
            }
        }
        return false;
    }

    public int indexOf(T data) {
        Node<T> current;
        int i = 0;
        for (current = head; current != null; current = current.next) {
            if (current.node.equals(data)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public boolean contains(T data) {
        return indexOf(data) != -1;
    }


    private static class Node<T> {
        private T node;
        private Node<T> next;
        private Node<T> previous;

        public Node(T node, Node<T> previous, Node<T> next) {
            this.node = node;
            this.previous = previous;
            this.next = next;
        }

        @Override
        public String toString() {
            return node.toString();
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.node;
                current = current.next;
                return data;
            }
        };
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current.next!=null){
            sb.append(current.node).append(", ");
            current = current.next;
        }
        sb.append(current).append("]");
        return sb.toString();
    }
}
