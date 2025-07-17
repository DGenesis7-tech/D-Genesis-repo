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

int largest = num1;
int sLargest = num2;

if (num2 > largest){
   largest = num2;
   sLargest = num1;
if (num3 > largest);
   sLargest = num2;
   largest = num3;
} else if (num3 > sLargest && num3 != largest);{
    sLargest = num3;

System.out.printf("largest is %d%n", largest);
System.out.printf("Second largest is %d", sLargest);}
}
}


