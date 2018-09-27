import java.util.Scanner;
public class Match{
public static void main(String args[])
{
int target=66;

Scanner sc=new Scanner(System.in);
System.out.println("Enter num between 1-100 ");
int s=sc.nextInt();
while(s!=target){


 if(s>target)
{
System.out.println("greater");
System.out.println("Enter num between 1-100 ");
s=sc.nextInt();
}
else if(s<target)
{
System.out.println("less");
System.out.println("Enter num between 1-100 ");
s=sc.nextInt();
}
}
if(s==target){
System.out.println("target found");
}
}}

