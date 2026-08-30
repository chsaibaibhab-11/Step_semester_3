import java.util.*;
class BMICalculator{
static String getBmiStatus(double bmi){
if(bmi<18.5)return "Underweight";
if(bmi<25)return "Normal";
if(bmi<30)return "Overweight";
return "Obese";
}
static void printWellnessReport(double[] h,double[] w){
System.out.println("Person | Height | Weight | BMI | Status");
for(int i=0;i<h.length;i++){
double bmi=w[i]/(h[i]*h[i]);
System.out.printf("%d | %.2f | %.2f | %.2f | %s%n",i+1,h[i],w[i],bmi,getBmiStatus(bmi));
}
}
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
System.out.print("Enter number of people: ");
int n=sc.nextInt();
double[] h=new double[n];
double[] w=new double[n];
for(int i=0;i<n;i++){
System.out.print("Enter height: ");
h[i]=sc.nextDouble();
System.out.print("Enter weight: ");
w[i]=sc.nextDouble();
}
printWellnessReport(h,w);
}
}
