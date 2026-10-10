import java.util.*;
public class ProductInventoryCSVParser{
public static void parseInventoryRecord(String csvLine){
String[]a=csvLine.split(",");
if(a.length!=3){
System.out.println("Invalid Record");
return;
}
System.out.println("Product: "+a[0]+" | SKU: "+a[1]+" | Qty: "+a[2]);
}
public static void main(String[]args){
Scanner sc=new Scanner(System.in);
String csvLine=sc.nextLine();
parseInventoryRecord(csvLine);
}
}
