import java.util.Scanner;                                                                                                                       
public class COD{
public static void main (String [] args){
Scanner input = new Scanner(System.in);

System.out.println("Enter the driving distance: ");
double drivingDistance = input.nextDouble();

System.out.println("Enter miles per gallon: ");
double milespergallon = input.nextDouble();

System.out.println("Enter price per gallon: ");
double pricepergallon = input.nextDouble();

double DDPPG = drivingDistance * pricepergallon;

double Cost = DDPPG / milespergallon;

System.out.printf("The cost of driving is $%.2f%n", Cost);

}
}