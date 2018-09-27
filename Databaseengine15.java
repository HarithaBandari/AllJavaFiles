//step9
import java.util.Scanner;
public class Databaseengine15{
public static void main(String args[])
{
String str=" select team1, sum(win_by_runs) from ipl.csv where season > 2016 and city='Bangalore' group by team1;";
String[] s1=str.split("group by");
String s2=s1[1];
String[] s3=s2.split(";");
String s4=s3[0];
System.out.println(s4);
}
}
