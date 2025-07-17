import java.util.Scanner;
public class Multiples{
public static void main (String [] args){
Scanner input = new Scanner(System.in);

System.out.print("Enter a number: ");
int number = input.nextInt();

int x = number / 6;
int y = number / 7;

if (number % 6 == 0 || number % 7 == 0){
System.out.println("Number is a multiple of six or seven");}
else {
System.out.println("Number is not a multiple of six or seven");}
}
}