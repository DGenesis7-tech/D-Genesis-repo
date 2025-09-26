import java.util.Scanner;
public class AssCh2217{
public static void main (String [] args){
Scanner input = new Scanner(System.in);

System.out.print("Enter first number: " );
int number1 = input.nextInt();

System.out.print("Enter your second number: ");
int number2 = input.nextInt();

System.out.print("Enter your third number: ");
int number3 = input.nextInt();

int sum = number1 + number2 + number3;
int avr = sum / 3;
int prd = number1 * number2 * number3;
int LargestN = number1;
int SmallestN = number1;

if (number2 > LargestN) {LargestN = number2;};
if (number3 > LargestN) {LargestN = number3;};

if (number2 < number1) {SmallestN = number2;};
if (number3 < number2) {SmallestN = number3;};

System.out.printf("%n%d%s",LargestN, " is the largest number");
System.out.printf("%n%d%s",SmallestN, " is the smallest number");
System.out.printf("%n%d%s",sum, " is the sum ");
System.out.printf("%n%d%s",prd, " is the product ");
System.out.printf("%n%d%s",avr, " is the average ");

}
}
