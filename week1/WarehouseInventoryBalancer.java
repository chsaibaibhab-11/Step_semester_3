import java.util.*;
class WarehouseInventoryBalancer{
static void analyzeInventory(int[] a,int[] b){
int sumA=0,sumB=0,max=Integer.MIN_VALUE,index=0;
String section="";
for(int i=0;i<a.length;i++){
sumA+=a[i];
if(a[i]>max){
max=a[i];
index=i;
section="Section A";
}
}
for(int i=0;i<b.length;i++){
sumB+=b[i];
if(b[i]>max){
max=b[i];
index=i;
section="Section B";
}
}
String status=sumA==sumB?"Balanced":"Not Balanced";
System.out.println("Section A Total: "+sumA+" | Section B Total: "+sumB+" | Status: "+status);
System.out.println("Highest Quantity: "+max+" ("+section+", Item "+(index+1)+")");
}
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int[] a=new int[n];
int[] b=new int[n];
for(int i=0;i<n;i++)a[i]=sc.nextInt();
for(int i=0;i<n;i++)b[i]=sc.nextInt();
analyzeInventory(a,b);
}
}
