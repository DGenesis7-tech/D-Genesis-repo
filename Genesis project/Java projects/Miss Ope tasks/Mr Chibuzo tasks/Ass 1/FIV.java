import java.util.Scanner;                                                                                                                       
public class FIV{
public static void main (String [] args){
Scanner input = new Scanner(System.in);

System.out.print("Enter investment amount: " );
double invAmount = input.nextDouble();

System.out.print("Enter annual interest rate in percentage: " );
double annualIr = input.nextDouble();

System.out.print("Enter number of years: " );
double numberOy = input.nextDouble();

// Converting interest rate from percentage to decimal
double monthlyIr = annualIr / 100;

double futureIv = invAmount * Math.pow(1 + monthlyIr, numberOy);

System.out.printf("Accumulated value is %.2f", futureIv);

}
}
