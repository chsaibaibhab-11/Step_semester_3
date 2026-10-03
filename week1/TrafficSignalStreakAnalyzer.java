import java.util.*;
class TrafficSignalStreakAnalyzer{
static void findLongestStreak(String s){
if(s.length()==0)return;
char maxChar=s.charAt(0);
int max=1,count=1;
for(int i=1;i<s.length();i++){
if(s.charAt(i)==s.charAt(i-1))count++;
else count=1;
if(count>max){
max=count;
maxChar=s.charAt(i);
}
}
System.out.println("Longest Streak: '"+maxChar+"' repeated "+max+" times");
}
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
String s=sc.nextLine();
findLongestStreak(s);
}
}
