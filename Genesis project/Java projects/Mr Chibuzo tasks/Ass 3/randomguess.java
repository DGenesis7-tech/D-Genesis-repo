import java.util.Scanner;
public class randomguess{
public static void main(String[] args){
Scanner input = new Scanner(System.in);
int number;
int random = (int)(Math.random() * 7);
do{
System.out.print("Guess the random number: ");
number = input.nextInt();
if (number == random){
	System.out.println("You guessed right");
	} 
	else {
	System.out.println("You guessed wrong");
	System.out.println("Try again");
	}
	
	} while (number != random);
	

	}
	}
	