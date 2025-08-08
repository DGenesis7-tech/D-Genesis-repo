public class task7 {
public static void main(String[] args){
int number = 1;
while (number <= 10) {
	if (number % 4 == 0){
	int sum = (number) + (number * number) + (number * number * number) + (number * number * number * number) + (number * number * number * number * number);
	System.out.print(sum + " ");	
	}
number++;
} 
}
}

