import java.util.Scanner;                                                                                                                       
public class BMI{
public static void main (String [] args){
Scanner input = new Scanner(System.in);

System.out.println("Enter weight in pounds e.g \"1 pound\": ");
double weightInPounds = input.nextDouble();

System.out.println("Enter height in inches e.g \"1 inch\": ");
double heightInInches = input.nextDouble();

final double kilogram_per_pound = 0.45359237;
final double meters_per_inch = 0.0254;

double weightInKilograms = weightInPounds * kilogram_per_pound;
double heightInMeters = heightInInches * meters_per_inch;

double bmi = weightInKilograms / (heightInMeters * heightInMeters);

System.out.printf("BMI is %.3f%n", bmi);

}
}