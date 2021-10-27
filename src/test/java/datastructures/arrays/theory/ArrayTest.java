package datastructures.arrays.theory;


import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayTest {



    @Test
    void test(){
        Array<Integer> array = new Array<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        assertEquals("[1, 2, 3, 4, 5]",array.toString());
        assertEquals(2, array.indexOf(3));
        assertTrue(array.contains(3));
        assertFalse(array.contains(8));

        assertTrue(array.remove(3));
        assertEquals("[1, 2, 4, 5]",array.toString());
        assertEquals(2, array.removeAt(1));
        assertEquals("[1, 4, 5]",array.toString());

        assertTrue(array.add(6));
        assertEquals("[1, 4, 5, 6]",array.toString());

        array.set(2,8);
        assertEquals("[1, 4, 8, 6]",array.toString());
        assertEquals(1, array.get(0));
        assertEquals(4, array.size());

        Iterator<Integer> iterator = array.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        assertFalse(array.isEmpty());
        array.clear();
        assertTrue(array.isEmpty());
        assertEquals("[]", array.toString());

    }


}
