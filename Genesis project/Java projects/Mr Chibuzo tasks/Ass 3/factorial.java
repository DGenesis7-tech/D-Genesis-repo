import java.util.Scanner;
public class factorial{
public static void main(String[] args){
Scanner input = new Scanner(System.in);

System.out.print("Enter a number: ");
int number = input.next.Int();
int factorial = 1;
int a = 1;
if (number >= 1){
	for(a = 1; a <= number; a += a){
	factorial *= a;
	}
	System.out.println("Factorial is: " + factorial);
	 else {
	System.out.println("Invalid input");
	}
	}