import java.util.*;
public class StopWordFilteredWordFrequency{
public static void printFilteredWordFrequency(String feedback){
feedback=feedback.toLowerCase().replace(".","").replace(",","");
String[]words=feedback.split("\\s+");
HashSet<String>stopWords=new HashSet<>(Arrays.asList("the","was","and","a","is","of","in"));
HashMap<String,Integer>map=new HashMap<>();
for(String word:words){
if(!stopWords.contains(word)&&!word.isEmpty())
map.put(word,map.getOrDefault(word,0)+1);
}
List<Map.Entry<String,Integer>>list=new ArrayList<>(map.entrySet());
list.sort((a,b)->b.getValue()-a.getValue());
for(Map.Entry<String,Integer>entry:list)
System.out.println(entry.getKey()+": "+entry.getValue());
}
public static void main(String[]args){
Scanner sc=new Scanner(System.in);
String feedback=sc.nextLine();
printFilteredWordFrequency(feedback);
}
}
