import java.util.Scanner;
public class FeetMeters{
public static void main (String [] args){
Scanner input = new Scanner(System.in);

System.out.print("Enter value for feet: ");
double feet = input.nextDouble();

double meters = feet * 0.305;

System.out.printf("feet input is %.4f %s", meters, "meters");

}
}