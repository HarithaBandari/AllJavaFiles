//step10
import java.util.Scanner;
public class Databaseengine16{
public static void main(String args[])
{
String str=" select avg(win_by_wickets),min(win_by_runs) from ipl.csv; ";
String[] s1=str.split("select");
String s2=s1[1];
String[] s3=s2.split("from");
String s4=s3[0];
String[] s5=s4.split(",");
String s6=s5[0];
String[] s7=s6.split("(");
System.out.println(s7[0]);
System.out.println(s7[1]);
String s8=s5[1];
String[] s9=s8.split("(");


System.out.println(s9[0]);
System.out.println(s9[1]);
}
}
