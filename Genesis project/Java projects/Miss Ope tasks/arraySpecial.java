import java.util.Scanner;
public class arraySpecial{
public static void main(String[] args){
Scanner input = new Scanner(System.in);
System.out.print("Enter array length");
int length = input.nextInt();
int[] myArray = new int[length];
}

public static int[] myArray (int[] myArray){

for (int i = 0; i < myArray.length; i++){
myArray[i] = Math.random() * 10;
int index = myArray[i];
System.out.println(i + myArray[i]);
}
}
}