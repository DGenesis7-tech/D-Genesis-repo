import java.util.Scanner;
public class testRandom{
public static void main(String[] args){
Scanner input = new Scanner(System.in);

int random1 = (int)(Math.random()* 10);
int random2 = (int)(Math.random()* 10);
int random3 = (int)(Math.random()* 10);
int random4 = (int)(Math.random()* 10);
int random5 = (int)(Math.random()* 10);

//System.out.print("Choose an operator for the test '+-*/' : ");
//char operator = input.next().charAt(0); 

char[] operator = {+,-,*,/};

int correctAnswer = 0;
int wrongAnswer = 0;
for (int count = 0; count < 5; count +=1 ){
switch(operator){
case [0]:
	double realAnswer = random1 + random2;
	System.out.println(random1 + "+" + random2 + "= ");
	double answer = input.nextDouble();
	if (answer == realAnswer){
		System.out.println("Correct answer");
		correctAnswer += 1;
		}else {
			System.out.println("Wrong answer");
			wrongAnswer += 1;
			}
	break;
case [1]:
	double realAnswer = random3 - random4;
	System.out.println(random3 + "-" + random4 + "= ");
	double answer = input.nextInt();
	if (answer == realAnswer){
		System.out.println("Correct answer");
		correctAnswer += 1;
		}else {
			System.out.println("Wrong answer");
			wrongAnswer += 1;
			}
	break;
case [2]:
	double realAnswer = random5 * random1;
	System.out.println(random5 + "*" + random1 + "= ");
	double answer = input.nextInt();
	if (answer == realAnswer){
		System.out.println("Correct answer");
		correctAnswer += 1;
		}else {
			System.out.println("Wrong answer");
			wrongAnswer += 1;
			}
	break;
case [3]:
	double realAnswer = random1 + random3;
	System.out.println(random1 + "+" + random3 + "= ");
	double answer = input.nextInt();
	if (answer == realAnswer){
		System.out.println("Correct answer");
		correctAnswer += 1;
		}else {
			System.out.println("Wrong answer");
			wrongAnswer += 1;
			}
	break;			
}
}
System.out.println(correctAnswer);

}
}
