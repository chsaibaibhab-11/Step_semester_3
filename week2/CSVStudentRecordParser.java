import java.util.*;
public class CSVStudentRecordParser{
public static void parseStudentRecord(String csvLine){
String[]a=csvLine.split(",");
if(a.length!=3){
System.out.println("Invalid Record");
return;
}
System.out.println("Name: "+a[0]+" | Roll No: "+a[1]+" | Dept: "+a[2]);
}
public static void main(String[]args){
Scanner sc=new Scanner(System.in);
String csvLine=sc.nextLine();
parseStudentRecord(csvLine);
}
}
