import java.util.Scanner;
public class Record{
public static void main (String [] args){
Scanner input = new Scanner(System.in);

System.out.println("Enter your first number");
int number1 = input.nextInt();

System.out.println("Enter your second number");
int number2= input.nextInt();

System.out.println("Enter your third number");
int number3= input.nextInt();

System.out.println("Enter your fourth number");
int number4= input.nextInt();

System.out.println("Enter your fifth number");
int number5= input.nextInt();

int LargestN = number1;
int SecondL = -2_147_483_648;

if (number2 > LargestN) {LargestN = number2;};
if (number3 > LargestN) {LargestN = number3;};
if (number4 > LargestN) {LargestN = number4;};
if (number5 > LargestN) {LargestN = number5;};

if (number2 > SecondL & number2 != LargestN) {SecondL = number2;};
if (number3 > SecondL & number3 != LargestN) {SecondL = number3;};
if (number4 > SecondL & number4 != LargestN) {SecondL = number4;};
if (number5 > SecondL & number5 != LargestN) {SecondL = number5;};

System.out.printf("%n%d%s",LargestN, " is the largest number");
System.out.printf("%n%d%s",SecondL, " is the second largest number");


}
}
