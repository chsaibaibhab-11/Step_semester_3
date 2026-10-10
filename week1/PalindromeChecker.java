import java.util.*;
class PalindromeChecker{
static boolean isPalindromeIterative(String s){
int i=0,j=s.length()-1;
while(i<j){
if(s.charAt(i)!=s.charAt(j))return false;
i++;
j--;
}
return true;
}
static boolean isPalindromeRecursive(String s){
if(s.length()<=1)return true;
if(s.charAt(0)!=s.charAt(s.length()-1))return false;
return isPalindromeRecursive(s.substring(1,s.length()-1));
}
static boolean isPalindromeArrayReversal(String s){
char[] a=s.toCharArray();
char[] b=s.toCharArray();
for(int i=0,j=b.length-1;i<j;i++,j--){
char t=b[i];
b[i]=b[j];
b[j]=t;
}
return Arrays.equals(a,b);
}
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
String s=sc.nextLine();
System.out.println("Iterative: "+(isPalindromeIterative(s)?"Palindrome":"Not Palindrome"));
System.out.println("Recursive: "+(isPalindromeRecursive(s)?"Palindrome":"Not Palindrome"));
System.out.println("Array Reversal: "+(isPalindromeArrayReversal(s)?"Palindrome":"Not Palindrome"));
}
}
