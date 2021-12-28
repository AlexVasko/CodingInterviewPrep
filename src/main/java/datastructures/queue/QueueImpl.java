package datastructures.queue;

import java.util.Iterator;
import java.util.LinkedList;

public class QueueImpl<T> implements Iterable<T> {

    private LinkedList<T> list = new LinkedList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public T peek() {
        if (!isEmpty()) {
            return list.peekFirst();
        } else {
            throw new RuntimeException("Queue is empty");
        }
    }

    public T poll() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        } else {
            return list.pollFirst();
        }
    }

    public void offer(T element){
        list.addLast(element);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
