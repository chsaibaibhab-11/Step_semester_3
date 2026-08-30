import java.util.*;
public class LibraryISBNNormalizerValidator{
public static String normalizeCode(String raw){
raw=raw.trim();
return raw.substring(0,3).toUpperCase()+raw.substring(3);
}
public static String validateAndFormat(String code){
if(code.length()!=13)
return "Invalid: wrong length";
for(int i=0;i<3;i++){
if(!Character.isLetter(code.charAt(i)))
return "Invalid: publisher code must be 3 letters";
}
for(int i=3;i<13;i++){
if(!Character.isDigit(code.charAt(i)))
return "Invalid: body must contain only digits";
}
StringBuilder sb=new StringBuilder();
sb.append("[");
sb.append(code.substring(0,3));
sb.append("] YEAR: ");
sb.append(code.substring(3,7));
sb.append(" | CATALOG: ");
sb.append(code.substring(7,13));
return sb.toString();
}
public static void main(String[]args){
Scanner sc=new Scanner(System.in);
String raw=sc.nextLine().trim();
if(raw.length()<3){
System.out.println("Invalid: wrong length");
return;
}
String code=normalizeCode(raw);
System.out.println(validateAndFormat(code));
}
}
