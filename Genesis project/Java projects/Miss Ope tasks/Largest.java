import java.util.Scanner;
public class Largest{
public static void main (String [] args){
Scanner input = new Scanner(System.in);

System.out.println("Enter first number");
int num1 = input.nextInt();

System.out.println("Enter second number");
int num2 = input.nextInt();

System.out.println("Enter third number");
int num3 = input.nextInt();

if (num1 > num2 && num1 > num3 && num2 > num3){
int largest = num1;
int sLargest = num2;
System.out.printf("largest is %d%n", largest);
System.out.printf("Second largest is %d", sLargest);
} if (num1 > num2 && num1 > num3 && num3 > num2){
int largest = num1;
int sLargest = num3;
System.out.printf("largest is %d%n", largest);
System.out.printf("Second largest is %d", sLargest);
} if (num2 > num1 && num2 > num3 && num1 > num3){
int largest = num2;
int sLargest = num1;
System.out.printf("largest is %d%n", largest);
System.out.printf("Second largest is %d", sLargest);
} if (num2 > num1 && num2 > num3 && num3 > num1){
int largest = num2;
int sLargest = num3;
System.out.printf("largest is %d%n", largest);
System.out.printf("Second largest is %d", sLargest);
} if (num3 > num2 && num3 > num1 && num2 > num1){
int largest = num3;
int sLargest = num2;
System.out.printf("largest is %d%n", largest);
System.out.printf("Second largest is %d", sLargest);
} if (num3 > num2 && num3 > num1 && num1 > num2){
int largest = num3;
int sLargest = num1;
System.out.printf("largest is %d%n", largest);
System.out.printf("Second largest is %d", sLargest);
}
}
}

