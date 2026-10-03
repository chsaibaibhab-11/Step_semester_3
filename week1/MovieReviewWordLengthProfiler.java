import java.util.*;
class MovieReviewWordLengthProfiler{
static void classifyWordLengths(String review){
String[] words=review.trim().split("\\s+");
int shortWords=0,medium=0,longWords=0;
for(String word:words){
int n=word.length();
if(n<=4)shortWords++;
else if(n<=8)medium++;
else longWords++;
}
System.out.println("Short: "+shortWords+" | Medium: "+medium+" | Long: "+longWords);
}
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
String review=sc.nextLine();
classifyWordLengths(review);
}
}
