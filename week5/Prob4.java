public class Prob4{
private static double rowAverage(int[] row){
double sum=0;
for(int value:row)sum+=value;
return sum/row.length;
}
static String classifyMatches(int[][] runsPerOver,int threshold){
String result="";
for(int i=0;i<runsPerOver.length;i++){
if(i>0)result+=" | ";
result+="Match "+i+": "+(rowAverage(runsPerOver[i])>=threshold?"Power Surge":"Normal");
}
return result;
}
public static void main(String[] args){
int[][] runsPerOver={{4,6,8},{10,12,14},{2,3,1}};
int threshold=8;
System.out.println(classifyMatches(runsPerOver,threshold));
}
}
