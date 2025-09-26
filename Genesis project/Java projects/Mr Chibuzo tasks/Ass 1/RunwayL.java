import java.util.Scanner;
public class RunwayL{
public static void main (String [] args){
Scanner input = new Scanner(System.in);

System.out.print("Enter takeoff speed: ");
double valueA = input.nextDouble();

System.out.print("Enter acceleration: ");
double valueB = input.nextDouble();

double valueBSq = valueA * valueA;

double valueAc = 2 * valueB;

double length = valueBSq / valueAc;

System.out.printf("The minimum runway length for the airplane is %.3f", length);

}
}