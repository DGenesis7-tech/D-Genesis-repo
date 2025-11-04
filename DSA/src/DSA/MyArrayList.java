package DSA;

import java.util.Arrays;

public class MyArrayList<Element> {
    private Element[] elements;
    private int size;
    private int counter;

    public MyArrayList(int initialSize, Element[] elements) {
        this.size = initialSize;
        this.elements = elements;
    }

    public MyArrayList(Element[] elements) {
        this.size = 10;
        this.elements = elements;
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public void trimToSize() {
        elements = new <Element

    }

    public void add(int index, Element item) {
        this.elements[index] = item;
        counter++;
    }

    public boolean add(Element item) {
        for (int index = this.size; index < 0; index--) {
            if (elements[index - 1] == null) {
                elements[index] = item;
            }
            if (this.elements[index - 1] != null) {
                counter++;
                this.elements[index] = item;
            }
        }
        counter++;
        return true;
    }

}





