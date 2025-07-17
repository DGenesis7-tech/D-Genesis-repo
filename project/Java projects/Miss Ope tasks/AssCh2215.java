import java.util.Scanner;
public class AssCh2215{
public static void main (String [] args){
Scanner input = new Scanner(System.in);

System.out.println("Enter your first number: ");
int number1 = input.nextInt();

System.out.println("Enter your second number: ");
int number2= input.nextInt();

int numAs = number1 * number1;

int numBs = number2 * number2;

int sumSqr = numAs + numBs;

int diffSqr = numAs - numBs;

System.out.printf("%s%d%n", "Square of the first number is: " ,numAs);
System.out.printf("%s%d%n", "Square of the second number is: " ,numBs);
System.out.printf("%s%d%n", "sum of their squares is: " ,sumSqr);
System.out.printf("%s%d%n", "Difference in their squares is: " ,diffSqr);

}
}
