public class arraySort{
public static void main(String[] args) {
int[] scoresSort = new int[6];
int sortArr[] = new int[4];
int sortArray2[] = new int[2];
int[] scores = {40,35,49,57,61,44};

int count;
int largest = scores[0];
int smallest = scores[0];
int largestN= sortArr[0];
int smallestN = sortArr[0];
int largestNn = sortArray2[0];
int smallestNn = sortArray2[1];


for (count = 0; count < scores.length; count++) {
if (scores[count] <  smallest) {
smallest = scores[count];
}
if (scores[count] > largest){
largest = scores[count];
}
if (scores[count] > smallest && scores[count] < largest){
int counter = 0;
scores[count] = sortArr[counter] ;
counter ++;
}
} 
for (count = 0; count < sortArr.length; count++){
if (sortArr[count] < smallestN){
smallestN = sortArr[count];
}
if (sortArr[count] > largestN){
largestN = sortArr[count];
}
if (sortArr[count] > smallestN && sortArr[count] < largestN){
int counter = 0;
sortArr[count] = sortArray2[counter];
counter++;
}
}
if (sortArray2[0] < smallestNn){
smallestNn = sortArray2[0];
}
else {
largestNn = sortArray2[1];
}

scoresSort[0] = smallest;
scoresSort[1] = smallestN;
scoresSort[2] = smallestNn;
scoresSort[3] = largestNn;
scoresSort[4] = largestN;
scoresSort[5] = largest;


System.out.println(smallest + " " + smallestN + " " + smallestNn + " " + largestNn + " " + largestN + " " + largest);





}




}
