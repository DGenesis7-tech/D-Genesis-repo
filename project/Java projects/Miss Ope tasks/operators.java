import java.util.Scanner;
public class operators{
public static void main(String[] args){
Scanner input = new Scanner(System.in);

System.out.print("Enter an arithmetic operator '*/+-': ");
char operator = input.next().charAt(0);
System.out.print("Enter first number: ");
double number1 = input.nextDouble();
System.out.print("Enter second number: ");
double number2 = input.nextDouble();

switch (operator){
case '*' :
	System.out.println("result =" + (number1 * number2));
	break;
case '/' :
	System.out.println("result =" + (number1 /  number2));
	break;
case '+' :
	System.out.println("result =" + ( number1 + number2));
	break;
case '-' :
	System.out.println("result =" +(number1 - number2));
	break;
default :
	System.out.println("Invalid arithmetic operator");
	break;
}

}
}