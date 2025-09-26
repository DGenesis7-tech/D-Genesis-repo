import java.util.Scanner;
public class PoKilo1{
public static void main (String [] args){
Scanner input = new Scanner(System.in);

System.out.println("Enter weight in pounds");
double pounds = input.nextDouble();

double kilograms = pounds * 0.454;

System.out.printf(pounds + "pounds is equivalent to " + kilograms + "kilograms." );

}
}