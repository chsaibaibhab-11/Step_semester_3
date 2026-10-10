import java.util.*;
class ReverseCustomerName{
static String reverseCustomerName(String customerName){
String r="";
for(int i=customerName.length()-1;i>=0;i--)r+=customerName.charAt(i);
return r;
}
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
String name=sc.nextLine();
System.out.println("Original Name: "+name);
System.out.println("Reversed Name: "+reverseCustomerName(name));
}
}
