//step8
import java.util.Scanner;
public class Databaseengine14{
public static void main(String args[])
{
String str=" select * from ipl.csv where season > 2016 and city='Bangalore' order by win_by_runs;  ";
String[] s1=str.split("order by");
String s2=s1[1];
String[] s3=s2.split(";");
String s4=s3[0];
System.out.println(s4);
}
}
