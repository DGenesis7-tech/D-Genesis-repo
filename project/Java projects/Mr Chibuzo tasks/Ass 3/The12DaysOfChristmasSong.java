import java.util.Scanner;
public class The12DaysOfChristmasSong{
public static void main(String[] args){
Scanner input = new Scanner(System.in);
int daysOfChristmas = 0;

do {
System.out.println(":::> THE 12 DAYS OF CHRISTMAS SONG <:::");
System.out.println();
System.out.println("Please fill in the dash'__' by picking a day from 1~12 and 0 to exit ");
System.out.println();

}while (daysOfChristmas != 0 );
System.out.println("On the __ day of Christmas my true love sent to me. ");
daysOfChristmas = input.nextInt();
	
switch  (daysOfChristmas){
	case 1:
		System.out.println("A partridge in a pear tree");
		break;
	case 2: 
       		 System.out.println("""
Two turtle doves,
and A partridge in a pear tree
""");
		break;
	case 3: 
       		 System.out.println("""
Three french hens,       		 
Two turtle doves,
and A partridge in a pear tree
""");
		break;
	case 4: 
       		 System.out.println("""
Four calling birds,
Three french hens,       		 
Two turtle doves,
and A partridge in a pear tree
""");
		break;
	case 5: 
       		 System.out.println("""
Five golden rings,
Four calling birds,
Three french hens,       		 
Two turtle doves,
and A partridge in a pear tree
""");
		break;
	case 6: 
       		 System.out.println("""
Six geese a-laying,
Five golden rings,
Four calling birds,
Three french hens,       		 
Two turtle doves,
and A partridge in a pear tree
""");
		break;
	case 7: 
       		 System.out.println("""
Seven swans a-swimming,
Six geese a-laying,
Five golden rings,
Four calling birds,
Three french hens,       		 
Two turtle doves,
and A partridge in a pear tree
""");
		break;
	case 8: 
       		 System.out.println("""
Eight maids a-milking,
Seven swans a-swimming,
Six geese a-laying,
Five golden rings,
Four calling birds,
Three french hens,       		 
Two turtle doves,
and A partridge in a pear tree
""");
		break;
	case 9: 
       		 System.out.println("""
Nine ladies dancing,       		 
Eight maids a-milking,
Seven swans a-swimming,
Six geese a-laying,
Five golden rings,
Four calling birds,
Three french hens,       		 
Two turtle doves,
and A partridge in a pear tree
""");
		break;
	case 10: 
       		 System.out.println("""
Ten lords a-leaping,
Nine ladies dancing,       		 
Eight maids a-milking,
Seven swans a-swimming,
Six geese a-laying,
Five golden rings,
Four calling birds,
Three french hens,       		 
Two turtle doves,
and A partridge in a pear tree
""");
		break;
	case 11: 
       		 System.out.println("""
Eleven pipers piping,
Ten lords a-leaping,
Nine ladies dancing,       		 
Eight maids a-milking,
Seven swans a-swimming,
Six geese a-laying,
Five golden rings,
Four calling birds,
Three french hens,       		 
Two turtle doves,
and A partridge in a pear tree
""");
		break;
	case 12: 
       		 System.out.println("""
Twelve drummers drumming,
Eleven pipers piping,
Ten lords a-leaping,
Nine ladies dancing,       		 
Eight maids a-milking,
Seven swans a-swimming,
Six geese a-laying,
Five golden rings,
Four calling birds,
Three french hens,       		 
Two turtle doves,
and A partridge in a pear tree
""");
		break;
	case 0: 
		System.out.println("Bye!!!");
		break;
	default :
		 System.out.println("Please follow instructions");
		 break;
		 }		
}
}
