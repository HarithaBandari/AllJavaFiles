//step6
import java.util.Scanner;
public class Databaseengine12{
public static void main(String args[])
{
String str="select season,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' or date > '31-12-2014';";

String[] s=str.split("2014",2);
String s1=s[1];
String[] s2=s1.split("city");
 System.out.println("operator1 : "+s2[0]);



String[] s3=s1.split("'Bangalore'");
String s4=s3[1];
String[] s5=s4.split("date");
 System.out.println("operator2 : "+s5[0]);


}
}
