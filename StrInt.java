import java.util.Scanner;
public class StrInt{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter a string");
String str=sc.next();
System.out.println("Enter size");
int s=sc.nextInt();
String str1=str.substring(str.length()-s,str.length());
for(int i=0;i<s;i++){
str+=str1;
}
System.out.println(str);
}}
