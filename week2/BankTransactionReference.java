import java.util.*;
public class BankTransactionReference{
public static String normalizeReference(String raw){
raw=raw.trim();
return raw.substring(0,3).toUpperCase()+raw.substring(3);
}
public static String validateAndFormat(String reference){
if(reference.length()!=14)
return "Invalid: wrong length";
for(int i=0;i<3;i++){
if(!Character.isLetter(reference.charAt(i)))
return "Invalid: bank code must be 3 letters";
}
for(int i=3;i<14;i++){
if(!Character.isDigit(reference.charAt(i)))
return "Invalid: body must contain only digits";
}
StringBuilder sb=new StringBuilder();
sb.append("[");
sb.append(reference.substring(0,3));
sb.append("] DATE: ");
sb.append(reference.substring(3,5));
sb.append("/");
sb.append(reference.substring(5,7));
sb.append("/");
sb.append(reference.substring(7,9));
sb.append(" | SEQ: ");
sb.append(reference.substring(9,14));
return sb.toString();
}
public static void main(String[]args){
Scanner sc=new Scanner(System.in);
String raw=sc.nextLine();
raw=raw.trim();
if(raw.length()<3){
System.out.println("Invalid: wrong length");
return;
}
String reference=normalizeReference(raw);
System.out.println(validateAndFormat(reference));
}
}
