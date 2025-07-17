import java.util.Scanner;
public class Record2{
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
int SmallestN = number1;

if (number2 > LargestN) {LargestN = number2;};
if (number3 > LargestN) {LargestN = number3;};
if (number4 > LargestN) {LargestN = number4;};
if (number5 > LargestN) {LargestN = number5;};

if (number2 < number1) {SmallestN = number2;};
if (number3 < number2) {SmallestN = number3;};
if (number4 < number3) {SmallestN = number4;};
if (number5 < number4) {SmallestN = number5;};

System.out.printf("%n%d%s",LargestN, " is the largest number");
System.out.printf("%n%d%s",SmallestN, " is the smallest number");

}
}
