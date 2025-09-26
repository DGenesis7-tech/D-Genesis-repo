import java.util.Scanner;
public class Years{
public static void main (String [] args){
Scanner input = new Scanner(System.in);

System.out.print("Welcome: please enter a year or a leap year using the number of days in it: ");
double y = input.nextDouble();

double lY = 366;

double iY = lY - y;

if (iY == 0){
System.out.println("Input is a leap year");}
else if (iY == 1){
System.out.println("Input is a year");}
else {
System.out.println("Incorrect input");}
}
}