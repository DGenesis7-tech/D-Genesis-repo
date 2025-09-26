import java.util.Scanner;
public class ConsonantsVowels{
public static void main (String [] args){
Scanner input = new Scanner(System.in);

System.out.print("Enter a single letter: " );
char letter = input.next().charAt(0);

if(letter == 'A' || letter == 'a'){
System.out.println("Letter ia a vowel");}

else if(letter == 'E' || letter == 'e'){
System.out.println("Letter ia a vowel");}

else if(letter == 'I' || letter == '1'){
System.out.println("Letter ia a vowel");}

else if(letter == 'O' || letter == 'o'){
System.out.println("Letter ia a vowel");}

else if(letter == 'U' || letter == 'u'){
System.out.println("Letter ia a vowel");}

else {
System.out.println("Letter ia a consonant");
}
}
}
