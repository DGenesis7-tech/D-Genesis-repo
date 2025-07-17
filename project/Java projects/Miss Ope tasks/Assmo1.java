import java.util.Scanner;                                                                                                                       
public class Assmo1{
public static void main (String [] args){
Scanner input = new Scanner(System.in);

System.out.println("Enter first integer value a:");
int a = input.nextInt();

System.out.println("Enter second integer value b:");
int b = input.nextInt();

a = a + b;
b = a - b;
a = a - b;

System.out.println("The value of a is: " +a );
System.out.println("The value of b is: " +b);

}
}
