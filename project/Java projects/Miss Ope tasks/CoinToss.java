import java.util.Scanner;
import java.security.SecureRandom;
public class CoinToss{
public static void main(String[] args){
Scanner input = new Scanner(System.in);
SecureRandom randomNumbers = new SecureRandom();

int coin = randomNumbers.nextInt(2);

System.out.println("Guess the result of the coin toss?");
System.out.print("Enter 0 or 1 for Heads or Tails respectively: ");
int pick = input.nextInt();

if (pick != 1 && pick != 0){
System.out.println("Input is not valid!!. Enter 0 or 1 !.");}
else if (pick == 1 || pick == 0){
System.out.println("Result is Heads.");}
else {
System.out.println("Result is tails.");
}
}
}

