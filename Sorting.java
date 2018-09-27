import java.util.Scanner;
public class Sorting{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter size");
int s=sc.nextInt();
System.out.println("Enter number");
int n=sc.nextInt();

int a[]=new int[n];
for(int i=0;i<s;i++){
int rem=n%10;
a[i]=rem;
n=n/10;
}
int temp,i;
 for ( i = 0; i <s; i++) 
 {
 for (int j = i + 1; j < s; j++) 
 {
  if (a[i] < a[j]) 
  {
  temp = a[i];
 a[i] = a[j];
       a[j] = temp;

      }
}}
for(i=0;i<s;i++){
       System.out.print(a[i]); 
   
}
int sum=0;
for(i=0;i<s;i++){
if(((a[i])%2)==0)
sum=sum+a[i];

}
 System.out.println("\n"+sum);
if(sum>15){
System.out.println("True");
}
else
System.out.println("False");


}
}






public boolean isGreater(int n, int s) {

		int sum = 0;
		int a[] = new int[n];
		for (int i = 0; i < s; i++) {
			if (((a[i]) % 2) == 0)
				sum = sum + a[i];
		}
		System.out.println("\n" + sum);
		if (sum > 15)
			return true;
		else
			return false;
	}
