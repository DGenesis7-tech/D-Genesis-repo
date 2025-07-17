import java.util.Scanner;
public class ATri{
public static void main (String [] args){
Scanner input = new Scanner(System.in);

System.out.println("Enter point1 (x1 and y1)");
double x1 = input.nextDouble();
double y1 = input.nextDouble();

System.out.println("Enter point1 (x2 and y2)");
double x2 = input.nextDouble();
double y2 = input.nextDouble();

System.out.println("Enter point1 (x3 and y3)");
double x3 = input.nextDouble();
double y3 = input.nextDouble();

double sx = Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
double sy = Math.sqrt((x3 - x2)*(x3 - x2) + (y3 - y2)*(y3 - y2));
double sz = Math.sqrt((x1 - x3)*(x1 - x3) + (y1 - y3)*(y1 - y3));

double s = (sx + sy + sz) / 2;

double ar = s * (s - sx) * (s - sy) * (s - sz);

double a = Math.sqrt(ar);

System.out.printf("The area of the triangle is %.3f%n", + a);

}
}


