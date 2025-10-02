package DSA;

import java.util.ArrayList;

public class MyStack {
    private ArrayList<Object> elements;
    private int size;

    public MyStack(int size) {
        this.size = size;
        this.elements = new ArrayList<>(size);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int getSize() {
        return elements.size();
    }

    public void push(Object item) {
        if (getSize() >= size) {
            throw new IllegalAccessError("Stack is full");
        }
        elements.add(item);
    }

    public Object pop() {
        if (isEmpty()) {
            throw new IllegalAccessError("Stack is empty");
        }
        return elements.removeLast();
    }

    public Object peek() {
        if (isEmpty()) {
            throw new IllegalAccessError("Stack is empty");
        }
        return elements.getLast();
    }

    public int search(Object item) {
        return elements.indexOf(item);
    }
}