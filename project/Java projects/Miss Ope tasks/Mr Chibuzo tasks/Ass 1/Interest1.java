import java.util.Scanner;                                                                                                                       
public class Interest1{
public static void main (String [] args){
Scanner input = new Scanner(System.in);

System.out.println("Input Balance");
double balance = input.nextDouble();

System.out.println("Input annual interest rate (e.g 5 is 5%)");
double annualinterestrate = input.nextDouble();

double interestM = balance * (annualinterestrate / 1200);

System.out.printf("The next monthly payment interest is %.3f%n ", interestM);

}
}


