import java.util.Scanner;
public class Alphabetcasecheck{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter a character");
char c=sc.next().charAt(0);
if(c>='A'&&c<='Z')
System.out.println(c+" is capital");
else if(c>='a'&&c<='z')
System.out.println(c+" is small");
else if(c>='0'&&c<='9')
System.out.println(c+" is digit");
else
System.out.println(c+" is special symbol");
}
}
