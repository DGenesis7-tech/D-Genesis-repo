import java.util.Scanner;
public class SumSet{
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

int even = 0;
int odd = 0;
int numOe = number1 % 2;
int numTe = number2 % 2;
int numThe = number3 % 2;
int numFe = number4 % 2;
int numFie = number5 % 2;

if (numOe == 0) {numOe = even + number1;}
if (numOe == 1) {numOe = odd + number1;}

if (numTe == 0) {numTe = even + number2;}
if (numTe == 1) {numTe = odd + number2;}

if (numThe == 0) {numThe = +even;}
if (numThe == 1) {numThe = +odd;}

if (numFe == 0) {numFe = +even;}
if (numFe == 1) {numFe = +odd;}

if (numFie == 0) {numFie = +even;}
if (numFie == 1) {numFie = +odd;}

int sumEv = even + even + even + even + even;
int sumOd = odd + odd + odd + odd + odd;

System.out.printf("%s%d%n", "The sum of evens is: ", sumEv);
System.out.printf("%s%d%n", "The sum of odds is: ", sumOd);

}
}
