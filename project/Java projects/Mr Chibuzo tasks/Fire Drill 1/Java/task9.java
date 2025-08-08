public class task9 {
public static void main(String[] args){
int number = 1;
int sum = 0;
int sum1 = 0;
while (number <= 10) {
	if (number % 4 == 0 && number != 8){
	sum = (number) + (number * number) + (number * number * number) + (number * number * number * number) + (number * number * number * number * number);
	}
	if (number % 4 == 0 && number != 4 && number == 8){
	sum1 = (number) + (number * number) + (number * number * number) + (number * number * number * number) + (number * number * number * number * number);
	System.out.print((sum + sum1) * (sum + sum1));	
	}
number++;
} 
}
}
