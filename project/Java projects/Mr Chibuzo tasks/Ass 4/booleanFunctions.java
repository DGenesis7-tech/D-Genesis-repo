public class booleanFunctions{

public static boolean isEven(int num){
 boolean result = num % 2 == 0;
 return result;
}	

public static boolean isPrimeNumber(int num){
boolean result = num % num == 0 && num % 1 == 0;
return result;
}
}
\t