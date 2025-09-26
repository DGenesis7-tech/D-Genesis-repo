import java.util.Scanner;
public class largestSmallestloop{
public static void main(String[] args){
Scanner input = new Scanner(System.in);
double number;

do{
System.out.println("Enter a number. One number per entry and enter 0.1 to stop : ");
number = input.nextDouble();
int largest = number;
int smallest = number;
if (number > largest){
	largest = number;
	}
	 if (number < largest) {
	number = smallest ;
	}
}while(number != 0.1);
System.out.println("largest is: " + largest);
System.out.println("smallest is: " + largest);

