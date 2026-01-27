package org.example;

public class ArraysEdit {
    int[] arraySquared = new int[10];
    int[] sorted = new int[arraySquared.length];

    public int[] arraySquare(int[] numbers) {
        for (int index = 0; index < numbers.length; index++) {
            arraySquared[index] = numbers[index] * numbers[index];
        }
        return arraySquared;
    }

    public int[] arraySquaredSorted(int[] arraySquared) {
        for (int index1 = 0; index1 < sorted.length - 1; index1++) {
            for (int index2 = 0; index2 < sorted.length - index1 - 1; index2++) {
                if (sorted[index2] > sorted[index2 + 1]) {
                    int position = sorted[index2];
                    sorted[index2] = sorted[index2 + 1];
                    sorted[index2 + 1] = position;
                }
            }
        }
        return sorted;
    }


    public int[] removeDuplicates(int[] sorted) {
        for (int index = 0; index < sorted.length; index++) {
            if (sorted[index] != sorted[index + 1]) {
                sorted[index + 1] = sorted[index];
                index++;
            }
        }
        return sorted;

    }


}





