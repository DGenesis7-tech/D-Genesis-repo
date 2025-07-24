import java.util.Scanner;
public class power{
public static void main(String[] args){
Scanner input = new Scanner(System.in);

System.out.print("Enter first number: ");
int number1 = input.nextInt();
System.out.print("Enter second number: ");
int number2 = input.nextInt();
int power = 1;
for(int power1 = 1; power1 <= number2; power1++){
	power *= number1;
}
System.out.println("First number raised to the power ofthe second number is: " + power);

int powerx = 1;
for(int power2 = 1; power2 <= number1; power2++){
powerx *= number2;
}

System.out.println("Second number raised to the power ofthe first number is: " +powerx);


	}
	}
