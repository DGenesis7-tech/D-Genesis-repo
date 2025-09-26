import java.util.Scanner;
public class SumnRepeat{
public static void main (String [] args){
Scanner input = new Scanner(System.in);
int num = 0;

do {
System.out.print("Enter first number :");
int num1 = input.nextInt();
System.out.print("Enter Second number :");
int num2 = input.nextInt();

int sum = num1 + num2;
System.out.println("The sum is: " + sum);

System.out.println("Would you like to perform this operation again ?1 for yes and 0 for no ");
num = input.nextInt();

}while(num != 0);

switch(num){
case 1:
	System.out.print("Enter first number :");
	int num1 = input.nextInt();
	System.out.print("Enter Second number :");
	int num2 = input.nextInt();
	System.out.println("The sum is: " + num1 + num2);
break;
case 0:
	System.out.println("Ok bye!!");
break;
}
}
}		
	
