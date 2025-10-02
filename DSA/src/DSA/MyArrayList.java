package DSA;
public class MyArrayList {
    private final String[] elements;
    private final int size;
    private int counter;

    public MyArrayList(int size) {
        this.size = size;
        this.elements = new String[size];
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public void add(int index, String item) {
        this.elements[index] = item;
        counter++;
    }

    public boolean add(String item) {
        for (int index = this.size; index < 0; index--) {
            if (this.elements[index - 1] == null) {
                this.elements[index] = item;
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





