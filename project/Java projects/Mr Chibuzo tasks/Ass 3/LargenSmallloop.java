import java.util.Scanner;
public class LargenSmallloop{
public static void main(String[] args){
Scanner input = new Scanner(System.in);
int number;
int again = 1;
do{
System.out.print("Enter a number: ");
number = input.nextInt();
int largest = number;
int smallest = number;

if (number > largest){
number = largest;
}
if (number < smallest){
number = smallest;
}
System.out.println("Would you like to enter another number? pick 1 or 2 for Yes or No");
again = input.nextInt();
}while (again == 1);
System.out.println("Largest is " + largest + " smallest is " + smallest);
}
}