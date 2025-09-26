import java.util.Scanner;
public class Arraylist{
public static void main(String[] args){
Scanner input = new Scanner(System.in);
	int[] scores = new int[5];
	int i = 0;
	do{
	System.out.print("Enter scores consecutively 5 times: ");
	scores[i] = input.nextInt();
	i++;
	}while (i < 5);
	System.out.println(scores[0]);
	
 	
 	





}

}