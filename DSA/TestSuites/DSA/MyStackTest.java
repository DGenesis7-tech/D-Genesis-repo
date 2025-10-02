package DSA;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest {

    @Test
    public void testStackSize_TestThatStackIsEmpty() {
        MyStack stack = new MyStack(4);
        Assertions.assertTrue(stack.isEmpty());
        Assertions.assertEquals(0, stack.getSize());
    }

    @Test
    public void testStackPush_TestThatStackIsNotEmpty() {
        MyStack stack = new MyStack(4);
        stack.push("item");
        Assertions.assertFalse(stack.isEmpty());
        Assertions.assertEquals(1, stack.getSize());
    }

    @Test
    public void testStackPush_TestThatStackThrowsExceptionWhenStackIsFull() {
        MyStack stack = new MyStack(3);
        stack.push(1);
        stack.push("boy");
        stack.push("2");

        assertThrows(IllegalAccessError.class, () -> stack.push("boy"));
    }

    @Test
    public void testStackPop_TestThatPopReturnsLastPushedItem() {
        MyStack stack = new MyStack(3);
        stack.push("item1");
        stack.push("item2");
        stack.push("item3");
        Object item = stack.pop();
        assertEquals("item3", item.toString());
    }

    @Test
    public void testStackPop_TestThatPopThrowsExceptionWhenStackIsEmpty() {
        MyStack stack = new MyStack(1);
        assertThrows(IllegalAccessError.class, () -> stack.pop());
    }

    @Test
    public void testStackPeek_TestThatPeekReturnsLastPushedItem() {
        MyStack stack = new MyStack(3);
        stack.push("item1");
        stack.push("item2");
        stack.push("item3");
        Assertions.assertEquals("item3", stack.peek());
    }

    @Test
    public void testStackPeek_TestThatPeekThrowsExceptionWhenStackIsEmpty() {
        MyStack stack = new MyStack(1);
        assertThrows(IllegalAccessError.class, () -> stack.peek());
    }

    @Test
    public void testStackSearch_TestThatSearchReturnsIndexOfItem() {
        MyStack stack = new MyStack(3);
        stack.push("item1");
        stack.push("item2");
        stack.push("item3");
        Assertions.assertEquals(1, stack.search("item2"));
    }
}



