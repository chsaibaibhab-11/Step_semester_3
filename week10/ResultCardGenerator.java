import java.util.Scanner;
class Student {
    String name;
    int[] marks;
    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }
    public double calculateAverage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }
    public char getGrade(double average) {
        if (average >= 75) {
            return 'B';
        } else if (average >= 40 && average <= 59) {
            return 'D';
        } else {
            return 'C';
        }
    }
}
public class ResultCardGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String marksStr = scanner.nextLine().replaceAll("[\\[\\] ]", "");

        String[] marksArray = marksStr.split(",");
        int[] marks = new int[marksArray.length];

        for (int i = 0; i < marksArray.length; i++) {
            marks[i] = Integer.parseInt(marksArray[i]);
        }

        Student student = new Student(name, marks);
        double average = student.calculateAverage();
        char grade = student.getGrade(average);

        System.out.printf("%s: Average %.1f, Grade %c\n", student.name.toUpperCase(), average, grade);
        scanner.close();
    }
}
