import java.util.Scanner;
public class SumI{
public static void main (String [] args){
Scanner input = new Scanner(System.in);

System.out.print("Enter a number between 0 and 1000:  ");
int number = input.nextInt();

int sum = 0;
int fNum = number / 10;
int lNum = number %  10;
int ffNum = fNum / 10;
int fmNum = fNum % 10;

if (number < 100){
 sum += (fNum + lNum);

System.out.printf("The sum is: %s", sum);}
 else if (number > 99 && number < 1000){
 sum += (lNum + fmNum + ffNum);

System.out.printf("The sum is: %s", sum);}
 else {
System.out.printf("Invalid input");}
}
}