import java.util.Scanner;                                                                                                                       
public class Energy{
public static void main (String [] args){
Scanner input = new Scanner(System.in);

System.out.println("Enter the amount of water in kilograms: ");
double amountOfWater = input.nextDouble();

System.out.println("Enter the initial temperature: ");
double initialTemperature = input.nextDouble();

System.out.println("Enter the final temperature: ");
double finalTemperature = input.nextDouble();

double temp = finalTemperature - initialTemperature;

double q = amountOfWater * temp * 4184;

System.out.printf("The energy needed is %.3f%n", q);

}
}

