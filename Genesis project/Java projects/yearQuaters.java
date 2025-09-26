public class yearQuaters{
public static void main(String[] args){

String[] month_in_year = {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
int count = 0;
int month = 3;
for (count = 0; count <= month_in_year.length; count++){
if (month <= 4 && count == (month - 1)) {
System.out.println("month " + month + " " + month_in_year[count] + " is part of the first quater");
}
if (month <= 8 && month > 4  && count == (month - 1)) {
System.out.println("month " + month + " " + month_in_year[count] + " is part of the second quater");
}
if (month <= 12 && month > 8  && count == (month - 1)) {
System.out.println("month " + month + " " + month_in_year[count] + " is part of the third quater");
}
}
}

}