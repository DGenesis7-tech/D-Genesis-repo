import java.util.Scanner;
public class vowelCount{
public static void main(String[] args){
Scanner input = new Scanner(System.in);
int count;
int countVowels = 0;
int countConsonants = 0;

System.out.print("Enter a sentence to know how many vowels it has : ");
String sentence = input.nextLine();

for(count = 0; count < sentence.length(); count ++){
char sentenceChar = sentence.charAt(count);
if ((sentenceChar == 'A' || sentenceChar == 'E' || sentenceChar == 'I' || sentenceChar == 'O' || sentenceChar == 'U') || (sentenceChar == 'a' || sentenceChar == 'e' || sentenceChar == 'i' || sentenceChar == 'o' || sentenceChar == 'u')){
countVowels += 1;
}
else {
countConsonants +=1;
}
}
System.out.println("Count of vowels = " + countVowels);
}
}

