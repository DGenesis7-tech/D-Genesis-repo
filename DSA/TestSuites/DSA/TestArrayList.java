package DSA;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestArrayList {
    @Test
    public void testIsEmpty_TestMyArrayListIsEmpty() {
        MyArrayList<Object> list = new MyArrayList<>(2);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testAdd_TestToAddToList() {
        MyArrayList<Object> list = new MyArrayList<>();
        assertTrue(list.isEmpty());
        list.add(0, "Boy");
        assertFalse(list.isEmpty());
    }

    @Test
    public void testAdd_TestToAddToEndOfListAndReturnTrue() {
        MyArrayList<Object> list = new MyArrayList<>();
        assertTrue(list.isEmpty());
        list.add("Boy");
        assertFalse(list.isEmpty());

    }
}
