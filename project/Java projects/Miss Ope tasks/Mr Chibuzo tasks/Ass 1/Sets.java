import java.util.Scanner;
public class Sets{
public static void main (String [] args){
Scanner input = new Scanner(System.in);

System.out.print("Enter first number: " );
int number1 = input.nextInt();

System.out.println("Enter your second number: ");
int number2 = input.nextInt();

System.out.println("Enter your third number: ");
int number3 = input.nextInt();

System.out.println("Enter your fourth number: ");
int number4 = input.nextInt();

System.out.println("Enter your fifth number: 
");
int number5 = input.nextInt();

int even = 0;
int odd = 0;
int x = 2;
{
if (number1 % x == 0) { ++ even;};
if (number1 % x != 0) { ++ odd;};

if (number2 % x == 0) { ++ even;};
if (number2 % x != 0) { ++ odd;};

if (number3 % x == 0) { ++ even;};
if (number3 % x != 0) { ++ odd;};

if (number4 % x == 0) { ++ even;};
if (number4 % x != 0) { ++ odd;};

if (number5 % x == 0) { ++ even;};
if (number5 % x != 0) { ++ odd;};

System.out.printf("Sum of even: %d", ++even );
}
}
}