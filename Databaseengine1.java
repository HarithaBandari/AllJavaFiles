import java.util.Scanner;
public class Databaseengine1{
public static void main(String args[])
{
String str="select * from ipl.csv where season > 2014 and city = 'Bangalore'";
String[] str1=str.trim().split(" ");
for (int i=0;i<str1.length;i++){

System.out.println(str1[i]);
}

//step2
String[] s=str.split("where");
String s1=s[0];
String[] s2=s1.split("from");
 System.out.println(s2[1]);

//step3
 System.out.println(s[1]);

//step4
String s3=s[1];
String[] s4=s3.split("and");
 System.out.println("condition 1: "+s4[0]);
 System.out.println("condition 2: "+s4[1]);

//step5

String s5=s4[0];
String[] s6=s5.split(" ");
System.out.println("variable : "+s6[1]);
System.out.println("operator : "+s6[2]);
System.out.println("value : "+s6[3]);


}}
