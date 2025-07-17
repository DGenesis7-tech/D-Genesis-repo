import java.util.Scanner;
public class The12DaysOfChristmasSong{
public static void main(String[] args){
Scanner input = new Scanner(System.in);

int daysOfChristmas = 2;
while (daysOfChristmas < 13){

System.out.println(":::> THE 12 DAYS OF CHRISTMAS SONG <:::");
System.out.println();
System.out.println("Please fill in the dash'__' by picking a day from 1~12");
System.out.println();
System.out.println("On the __ day of Christmas my true love said to me. ");
daysOfChristmas = input.nextInt();
int first = 1;
int second = 2;

if (daysOfChristmas == first){ 

switch (first){
case 1:
	System.out.println("A bird in a pear tree");
}
}
else if (daysOfChristmas == second){

switch (second){ 
case 1: 
        System.out.println("""
Two donkeys riding a horse
and A bird in a pear tree
""");
}
}
}
}
}