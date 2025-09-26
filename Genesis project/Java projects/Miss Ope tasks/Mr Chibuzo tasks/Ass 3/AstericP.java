public class AstericP{
public static void main(String[] args){

for (int a = 1; a > 0; a--){
System.out.print("""
*
**
***
****
*****
******
*******
********
*********
**********
""");
}
System.out.println();
for (int a = 0; a < 1; a += 1){
System.out.print("""
**********
*********
********
*******
******
*****
****
***
**
*
""");
}
System.out.println();
for (int a = 1; a > 0; a = a - 1){
System.out.print("""
**********
 *********
  ********
   *******
    ******
     *****
      ****
       ***
        **
         *
""");
}
System.out.println();
for (int a = 0; a < 1; a = a + 1){
System.out.print("""
         *
        **
       ***
      ****
     *****
    ******
   *******
  ********
 *********
**********
""");
}
}
}