import java.util.*;
class RockPaperScissors{
static String playRound(String p,String c){
if(p.equals(c))return "Draw";
if((p.equals("Rock")&&c.equals("Scissors"))||(p.equals("Paper")&&c.equals("Rock"))||(p.equals("Scissors")&&c.equals("Paper")))return "Player Wins";
return "Computer Wins";
}
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
Random r=new Random();
String[] moves={"Rock","Paper","Scissors"};
int w=0,l=0,d=0;
System.out.println("Round | Player | Computer | Result");
for(int i=1;i<=5;i++){
System.out.print("Enter move: ");
String p=sc.next();
p=p.substring(0,1).toUpperCase()+p.substring(1).toLowerCase();
String c=moves[r.nextInt(3)];
String result=playRound(p,c);
if(result.equals("Player Wins"))w++;
else if(result.equals("Computer Wins"))l++;
else d++;
System.out.println(i+" | "+p+" | "+c+" | "+result);
}
System.out.println("Wins: "+w);
System.out.println("Losses: "+l);
System.out.println("Draws: "+d);
System.out.println("Win %: "+(w*100.0/5)+"%");
}
}
