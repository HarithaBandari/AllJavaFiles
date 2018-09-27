import java.util.Scanner;
public class EvenNumTest{
public static boolean isEven(int n)
{

if((n%2)==0)
return true;
else 
return false;

}
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter a number");
int n=sc.nextInt();
if((isEven(n)))
    System.out.println( " true");
   else
    System.out.println("false");
}
}






