import java.util.*;
public class FileExtensionValidator{
public static String validateFileExtension(String filename){
int pos=filename.lastIndexOf('.');
if(pos==-1)
return "Rejected — invalid file type";
String ext=filename.substring(pos+1);
if(ext.equalsIgnoreCase("pdf")||ext.equalsIgnoreCase("docx")||ext.equalsIgnoreCase("zip"))
return "Accepted";
return "Rejected — invalid file type";
}
public static void main(String[]args){
Scanner sc=new Scanner(System.in);
String filename=sc.nextLine();
System.out.println(validateFileExtension(filename));
}
}
