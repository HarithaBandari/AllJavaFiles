import java.util.Scanner;
public class IntegerSum{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter n");
int n=sc.nextInt();
int sum=0;
System.out.println("Enter numbers");
int a[]=new int[n];


for(int i=0;i<n;i++){
a[i]=sc.nextInt();
}

for(int j=0;j<n;j++){
sum=sum+a[j];

}
System.out.println(sum);


}
}








