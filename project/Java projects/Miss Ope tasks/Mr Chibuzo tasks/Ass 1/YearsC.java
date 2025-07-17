import java.util.Scanner;                                                                                                                       
public class YearsC{
public static void main (String [] args){
Scanner input = new Scanner(System.in);

System.out.print("Enter the number of minutes: ");
double minutes = input.nextDouble();

double minutesInHour = 60;

double hoursInDay = 24;

double minutesInDay = minutesInHour * hoursInDay;

double daysInYear = 365;

double daysT = minutes / minutesInDay;

double yearsT = Math.floor(daysT / 365);

double daysR = daysT % 365;

System.out.printf("%.0f minutes is %.0f years and %.0f days", minutes, yearsT, daysR);
}
}
