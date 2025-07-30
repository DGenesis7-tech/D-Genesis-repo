import java.util.Scanner;
public class passwordAnalyzerFunctions{

public static String getPassword(){
Scanner input = new Scanner (System.in);	
System.out.print("Enter password using alphabets and numbers only: ");
String password = input.nextLine();
return password;
}

public static int checkComplexity1(String password){
int countLetter = 0;
int count;
for(count = 0; count < password.length(); count ++){
char passChar = password.charAt(count);

if ((passChar >= 'A' && passChar <= 'Z') || (passChar >= 'a' && passChar <= 'z')){
countLetter += 1;
}
}
System.out.println("Total number of 'alphabets' in password = " + countLetter);
return countLetter;
}


public static int checkComplexity2(String password){
int countNumber = 0;
int count;
for(count = 0; count < password.length(); count ++){
char passChar = password.charAt(count);
if (passChar >= '1' && passChar <= '9') {
countNumber += 1;
}
}
System.out.println("Total number of 'digits' in password = " + countNumber );
return countNumber ;
}
	

public static void evaluateStrength(int countLetter, int countNumber){
if (countLetter > 8 && countNumber >= 2){
System.out.println("The strength of password is STRONG");
}
else if ((countLetter > 5 &&  countLetter < 8) && countNumber >= 1){
System.out.println("The strength of password is MODERATE");
}
else {
System.out.println("The strength of password is WEAK");
}
}


}

	