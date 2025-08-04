public class ArrayKata{
public static void main(String[] args) {
int numbersInArray[] = {1, 2, 4, 3};
int answer[] = maximumAndMinimumOfArrayOfIntegers(numbersInArray);
System.out.println("Max and Min integer in array is: " + answer[0] + answer[1] );
}


public static int maximumInArrayOfIntegers(int[] numbersInArray){
int maximumInArray = numbersInArray[0]  ;
for (int count = 0; count < numbersInArray.length; count++) {
if (numbersInArray[count] > maximumInArray ) {
maximumInArray = numbersInArray[count];
}
}
return maximumInArray ;
}

public static int minimumInArrayOfIntegers(int[] numbersInArray){
int minimumInArray = numbersInArray[0];
for (int count = 0; count < numbersInArray.length; count += 1) {
if (numbersInArray[count] < minimumInArray ) {
minimumInArray = numbersInArray[count];
}
}
return minimumInArray ;
}

public static int sumOfArrayOfIntegers(int[] numbersInArray){
int sumInArray = 0;
int count;
for (count = 0; count < numbersInArray.length; count = count + 1) {
sumInArray = sumInArray + numbersInArray[count];
}
return sumInArray;
}

public static int sumOfEvenNumbersInArrayOfIntegers(int[] numbersInArray) {
int count;
int sumOfEvenInArray = 0;
for(count = 0; count < numbersInArray.length; count++ ) {
if (numbersInArray[count] % 2 == 0) {
sumOfEvenInArray += numbersInArray[count];
}
}
return sumOfEvenInArray;
}

public static int sumOfOddNumbersInArrayOfIntegers(int[] numbersInArray) {
int count;
int sumOfOddInArray = 0;
for(count = 0; count < numbersInArray.length; count++ ) {
if (numbersInArray[count] % 2 != 0) {
sumOfOddInArray += numbersInArray[count];
}
}
return sumOfOddInArray;
}

public static int[] maximumAndMinimumOfArrayOfIntegers(int[] numbersInArray){
int[] maximumAndMinimum = new int[2];
int maximumInArray = numbersInArray[0];
int minimumInArray = numbersInArray[0];
int count;
for (count = 0; count < numbersInArray.length; count++) {
if (numbersInArray[count] > maximumInArray ) {
maximumInArray = numbersInArray[count];
}
if (numbersInArray[count] < minimumInArray ) {
minimumInArray = numbersInArray[count];
}
}
for (count = 0; count < maximumAndMinimum.length; count++){ 
if (count == 0){
maximumAndMinimum[count] = maximumInArray; 
}
if (count == 1){
maximumAndMinimum[count] = minimumInArray;
}
}
return maximumAndMinimum ;
}



}




