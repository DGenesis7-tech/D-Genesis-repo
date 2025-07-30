import java.util.Scanner;
public class passwordAnalyzerApp{
public static void main(String[] args){
Scanner input = new Scanner(System.in);
String again;
do{
String password = passwordAnalyzerFunctions.getPassword();
int countLetter = passwordAnalyzerFunctions.checkComplexity1(password);	
int countNumber = passwordAnalyzerFunctions.checkComplexity2(password);	
passwordAnalyzerFunctions.evaluateStrength(countLetter, countNumber); 

System.out.print("Try another score? (yes/no): ");
again = input.next();
}while (again.equals("yes")) ;
if (again.equals("yes")){
System.out.println("Lets try again");
} else {
System.out.println("Ok, please come again");
System.out.println("Bye !!!");
}
}
}
