import java.util.Scanner;
public class Tom{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter a number");
int n=sc.nextInt();
if(n>20&&n<30){
if(n%2==0){
System.out.println("Jerry");
}else
System.out.println("Tom");
}
else
System.out.println("Out of boundary");
}
}
