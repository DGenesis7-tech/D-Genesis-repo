import java.util.Scanner;
public class Patterns1{
public static void main (String[] args){

System.out.println("Pattern A :");
int a = 1;
while(a <= 6){
	int b = 1;
	while(b <= a){
		System.out.print(b + " ");
	b = b + 1;
	}
System.out.println();
a = a + 1;
}
}
}
