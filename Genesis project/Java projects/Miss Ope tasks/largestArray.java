public class largestArray{
public static void main(String[] args){
int[] [] scores = {{40, 30}, {50, 20}, {20, 60}};
int largest = scores[0][0];
int smallest=  scores[0][0];


System.out.println("Values in array in rows and colums are");


for (int i = 0; i < scores.length; i++) {
           for (int j = 0; j < scores[i].length; j++) {
           int count = scores[i][j];
           System.out.print(scores[i][j] + " ");
           if (count > largest){
           largest = count;
           }
	if (count < smallest){
	smallest = count;
	}
	}
	System.out.println();
}	

System.out.println("Largest value = " + largest);
System.out.println("Smallest value = " + smallest);


}
}
