import java.util.Scanner;
public class Palindrome1{
public static void main(String[] args){
Scanner input = new Scanner(System.in);

System.out.print("Enter a word: ");
String p = input.nextLine();

int low = 0;

int high = p.length() - 1;

boolean isPalindrome = true;
while (low < high) {
if (p.charAt(low) != p.charAt(high)) {
isPalindrome = false;
  break;
}
 low++ ;
 high-- ;
 
}

if (isPalindrome)
System.out.println("User's word is a palindrome");
else 
System.out.println("User's word is not a palindrome");
}
}