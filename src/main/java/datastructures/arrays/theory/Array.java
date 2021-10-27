package datastructures.arrays.theory;

import java.util.Iterator;


/**
 * Dynamic Array class that implements an analog of ArrayList.
 * State is defined by three properties: size which represents the current size of the collection which
 * is visible to the user, capacity, which defines an actual size of underlying array and the array itself.
 * Behaviour is define by the following methods:
 * -size() - defines current size of the dynamic array, the one which is exposed to the user;
 * -isEmpty() - checks if collection is empty;
 * -get(int index) - get element by index;
 * -set(int index, T element);
 * -add(T element);
 * -clear(); - removes all elements of the array;
 * -removeAt(int index) - removes the element at specified index and shrinks the array
 * -remove(T element)
 * -indexOf(T element)
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class Array<T> implements Iterable<T> {

    private int size = 0;
    private int capacity;
    private T[] internalArray;


    public Array() {
        this(16);
    }

    public Array(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Array capacity can't be negative");
        internalArray = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public long size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int i) {
        if (i >= size || i < 0) throw new IndexOutOfBoundsException();
        return internalArray[i];
    }

    public void set(int i, T element) {
        if (i >= size || i < 0) throw new IndexOutOfBoundsException();
        internalArray[i] = element;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            internalArray[i] = null;
        }
        size = 0;
    }

    public boolean add(T element) {
        if (size + 1 >= capacity) {
            if (capacity == 0) capacity = 1;
            else capacity *= 2;
            Object[] tmpArray = new Object[capacity];
            for (int i = 0; i < size; i++) {
                tmpArray[i] = internalArray[i];
            }
            internalArray = (T[]) tmpArray;
        }
        internalArray[size++] = element;
        return true;
    }


    public T removeAt(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();
        T data = internalArray[index];
        Object[] tmpArray = new Object[capacity - 1];
        for (int i = 0, j = 0; i < capacity; i++, j++) {
            if (i == index) j--;
            else tmpArray[j] = internalArray[i];
        }
        internalArray = (T[]) tmpArray;
        size--;
        capacity = size;
        return data;
    }

    public boolean remove(T element) {
        for (int i = 0; i < size; i++) {
            if (internalArray[i].equals(element)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (internalArray[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    public Iterator<T> iterator() {

        return new Iterator<>() {
            int index = 0;

            public boolean hasNext() {
                return index < size;
            }

            public T next() {
                return internalArray[index++];
            }

            public void remove() {
                removeAt(index);
            }
        };
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(internalArray[i]).append(", ");
        }
        sb.append(internalArray[size - 1]).append("]");
        return sb.toString();
    }
}
