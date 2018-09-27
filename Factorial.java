import java.util.Scanner;
public class Factorial{
public static void factorial(){
int i,fact=1,n;
for(i=1;i<=12;i++){
fact=fact*i;
System.out.println("Factorial of " +i + " is "+fact);
}

if(i>=13)
System.out.println("Factorial of "+i+" is out of range");

}
public static void main(String args[]){
factorial();
}
}




