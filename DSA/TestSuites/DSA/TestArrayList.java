package DSA;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestArrayList {
    @Test
    public void testIsEmpty_TestMyArrayListIsEmpty() {
        MyArrayList list = new MyArrayList(2);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testAdd_TestToAddToList() {
        MyArrayList list = new MyArrayList(2);
        assertTrue(list.isEmpty());
        list.add(0, "Boy");
        assertFalse(list.isEmpty());
    }

    @Test
    public void testAdd_TestToAddToEndOfListAndReturnTrue() {
        MyArrayList list = new MyArrayList(2);
        assertTrue(list.isEmpty());
        list.add("Boy");
        assertFalse(list.isEmpty());

    }
}
