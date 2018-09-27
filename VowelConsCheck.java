import java.util.Scanner;
public class VowelConsCheck{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter a string");
String c=sc.next();
char[] s=c.toCharArray();

for(int i=0;i<s.length;i++){
if(s[i]>='A'&&s[i]<='z'){
if(s[i]=='a'||s[i]=='e'||s[i]=='i'||s[i]=='o'||s[i]=='u'||s[i]=='A'||s[i]=='E'||s[i]=='I'||s[i]=='O'||s[i]=='U'){
System.out.println(s[i]+"-"+"vowel");
}

else
System.out.println(s[i]+"-"+"consonent");}

else
System.out.println("Input is not a letter");}
}}
