import java.util.Scanner;
public class rangeArray{
public static void main(String[] args){
Scanner input = new Scanner(System.in);
	
	int[] number = {5,6,3,2,1};
	
	int largest = number[0];
	int smallest = number[0];
	if (number[1] > largest){
	largest = number[1];
	}
	if (number[2] > largest){
	largest = number[2];
	}
	if (number[3] > largest){
	largest = number[3];
	}
	if (number[4] > largest){
	largest = number[4];
	}
	if (number[1] < smallest){
	smallest = number[1];
	}
	if (number[2] < smallest){
	smallest = number[2];
	}
	if (number[3] < smallest){
	smallest = number[3];
	}
	if (number[4] < smallest){
	smallest = number[4];
	}
System.out.println("Range = " + (largest - smallest));
System.out.println(number.length);	
}
}
	
	


	
	
	
	
	
	
	
	
	