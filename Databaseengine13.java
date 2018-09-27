//step7
import java.util.Scanner;
public class Databaseengine13{
public static void main(String args[])
{
String str="select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore';";

String[] s1=str.split("select");
String s2=s1[1];
String[] s3=s2.split("from");
String s4=s3[0];
String[] s5=s4.split(",");
for(int i=0;i<s5.length;i++){
System.out.println(s5[i]);
}




}
}
