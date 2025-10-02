import java.util.Scanner;
public class astericTest{
public static void main(String[] args){
Scanner input = new Scanner(System.in);
int col = 0;
for(int sp = 0; sp <= 9; sp++){
	for(int count = 0 ; count <= (9 - sp); count++){
	System.out.print(" ");
	}
		for (col = 0; col <= sp; col++){	
	System.out.print("*");
	}
System.out.println();
}
System.out.println();
for(int sp = 0; sp <= 9; sp++){
	for(int count = sp ; count >= 0; count--){
	System.out.print("*");
	}
		for (col = 9; col <= (sp - 9) ; col--){	
	System.out.print(" ");
	}
System.out.println();
}
}
}
