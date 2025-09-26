import java.util.Scanner;
public class possitiveNegativrZeroes{
public static void main(String[] args){
Scanner input = new Scanner(System.in);
double number; 
int countp = 0;
int countn = 0;
int sumZeroes = 0;
int sumPossitive = 0;
int sumNegative = 0;
do{
System.out.println("Enter a number. One number per entry and enter 0.1 to stop : ");
number = input.nextDouble();

if (number >= 1){
	sumPossitive += 1;
	}
	 if (number < 0) {
	sumNegative += 1;
	}
	if (number == 0){
	sumZeroes += 1;
			}

}while(number != 0.1);
countp += sumPossitive;
countn += sumNegative;
System.out.println("Sum of negative is: " + sumNegative);
System.out.println("Sum of positive is: " + sumPossitive);
System.out.println("Sum of zeroes is: " + sumZeroes);


}
}
	
	
	 

