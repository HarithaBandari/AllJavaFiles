import java.util.Scanner;
public class Palindrome{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter a number");
int n=sc.nextInt();
int x,y=0;
 int temp=n;
while(n>0)
{
x=n%10;
y=y*10+x;
n=n/10;
}
if(temp==y)
{System.out.println(+y+"is a palindrome");
int sum=0;
while(y>0){
if(((y%10)%2)==0)
sum=sum+y%10;
y=y/10;
}
System.out.println("Sum of even numbers is:"+sum);
if(sum>25){
System.out.println("Sum of even numbers is greater than 25");
}
else
System.out.println("Sum of even numbers is less than 25");
}
else
{System.out.println(+y+"is not a palindrome");
}
}
}
