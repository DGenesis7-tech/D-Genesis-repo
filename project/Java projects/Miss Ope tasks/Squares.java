import java.util.Scanner;
public class Squares{
public static void main (String [] args){
Scanner input = new Scanner(System.in);

System.out.print("Enter a number between 1 to 5: ");
int number = input.nextInt();

int numberSqr = 0;

if (number == 1){
numberSqr = 1;
System.out.printf("Square of input is %d", numberSqr);}
else if (number == 2){
numberSqr = 4;
System.out.printf("Square of input is %d", numberSqr);}
else if (number == 3){
numberSqr = 9;
System.out.printf("Square of input is %d", numberSqr);}
else if (number == 4){
numberSqr = 16;
System.out.printf("Square of input is %d", numberSqr);}
else if (number == 5){
numberSqr = 25;
System.out.printf("Square of input is %d", numberSqr);}
else {
System.out.printf("Invalid input");}
}
}