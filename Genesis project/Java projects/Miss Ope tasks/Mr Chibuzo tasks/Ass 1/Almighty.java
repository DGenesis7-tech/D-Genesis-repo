import java.util.Scanner;
public class Almighty{
public static void main (String [] args){
Scanner input = new Scanner(System.in);

System.out.println("Enter the first number as coefficient a");
double a = input.nextDouble();

System.out.println("Enter the second number as coefficient b");
double b = input.nextDouble();

System.out.println("Enter the third number as coefficient c");
double c = input.nextDouble();

double d = (b * b) - 4 * a * c;

if (d > 0){

double px = (- b + Math.sqrt(d)) / 2 * a;

double nx = (- b - Math.sqrt(d)) / 2 * a;

System.out.printf("When determinant is greater than or equal to 0: x = %.2f%n", px );
System.out.printf("When determinant is greater than or equal to 0: x = %.2f%n", nx );
}

else if (d == 0){

System.out.printf("When the determinant is equal to 0: x = " );

}
}