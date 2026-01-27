package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArraysEdit array = new ArraysEdit();

        int[] userArray = new  int[10];

        for (int index = 0;  index < 10; index++ ) {
            System.out.println("Digite um valor: ");
            int value = input.nextInt();
            userArray[index] = value;
        }

        System.out.println(array.arraySquare(userArray));
        array.arraySquaredSorted(array.arraySquare(userArray));
        array.arraySquaredSorted(array.arraySquaredSorted(array.arraySquare(userArray)));
        }
    }

