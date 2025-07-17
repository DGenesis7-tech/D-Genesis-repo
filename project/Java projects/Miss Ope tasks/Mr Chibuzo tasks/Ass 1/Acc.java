import java.util.Scanner;
public class Acc{
public static void main (String [] args){
Scanner input = new Scanner(System.in);
 
System.out.print("formula for average acceleration is ");
System.out.println("a = (v1-v0) / t");

System.out.println("Enter starting velocity (v0)");
int num1 = input.nextInt();

System.out.println("Enter ending velocity (v1)");
int num2 = input.nextInt();

System.out.println("Enter time span (t)");
int num3 = input.nextInt();

int a = (num2 - num1) / num3;

System.out.printf("the average acceleration is %d", a);

}
}