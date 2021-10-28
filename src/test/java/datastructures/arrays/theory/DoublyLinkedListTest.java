package datastructures.arrays.theory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {


    @Test
    void test(){
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(7);
        assertEquals("[4, 5, 6, 7]", l.toString());
        l.addFirst(3);
        l.addFirst(2);
        assertEquals("[2, 3, 4, 5, 6, 7]", l.toString());
        l.addLast(10);
        l.addLast(11);
        assertEquals("[2, 3, 4, 5, 6, 7, 10, 11]", l.toString());
        assertTrue(l.remove(10));
        assertEquals("[2, 3, 4, 5, 6, 7, 11]", l.toString());
        l.removeLast();
        assertEquals("[2, 3, 4, 5, 6, 7]", l.toString());
        l.removeFirst();
        assertEquals("[3, 4, 5, 6, 7]", l.toString());
        assertEquals(5,l.size());
        assertTrue(l.contains(5));
        assertFalse(l.contains(9));
        l.removeAt(1);
        assertEquals(3,l.peekFirst());
        assertEquals(7,l.peekLast());
        assertEquals("[3, 5, 6, 7]", l.toString());
        assertFalse(l.isEmpty());
        l.clear();
        assertTrue(l.isEmpty());

    }

}
