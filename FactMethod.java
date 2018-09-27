import java.util.Scanner;
public class FactMethod{
public static void longFactorial(){
Long MAX_VALUE=20;
int i,fact=1,n;
for(i=1;i<=Long.MAX_VALUE;i++){
fact=fact*i;
System.out.println("Factorial of " +i + " is "+fact);
}

if(i>=21)
System.out.println("Factorial of "+i+" is out of range");

}
public static void main(String args[]){
longFactorial();
}
}




