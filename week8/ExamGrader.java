import java.util.Scanner;
public class ExamGrader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine();
        double totalScore = 0;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);
            int firstQuote = line.indexOf('"', firstSpace);
            int secondQuote = line.indexOf('"', firstQuote + 1);
            int thirdQuote = line.indexOf('"', secondQuote + 1);
            int fourthQuote = line.indexOf('"', thirdQuote + 1);
            String correct = line.substring(thirdQuote + 1, fourthQuote);

            int fifthQuote = line.indexOf('"', fourthQuote + 1);
            int sixthQuote = line.indexOf('"', fifthQuote + 1);
            String student = line.substring(fifthQuote + 1, sixthQuote);

            double points = Double.parseDouble(line.substring(sixthQuote + 1).trim());

            double score = 0;
            if (type.equals("MCQ") || type.equals("TF")) {
                if (student.trim().equalsIgnoreCase(correct.trim())) {
                    score = points;
                }
            } else if (type.equals("ESSAY")) {
                String[] keywords = correct.split(",");
                int matchCount = 0;
                String studentLower = student.toLowerCase();
                for (String kw : keywords) {
                    if (studentLower.contains(kw.trim().toLowerCase())) {
                        matchCount++;
                    }
                }
                if (matchCount >= 2) {
                    score = points * 0.75;
                } else if (matchCount == 1) {
                    score = points * 0.50;
                } else {
                    score = 0.0;
                }
            }
            totalScore += score;
            System.out.printf("%s: %.2f\n", type, score);
        }
        System.out.printf("Total Score: %.2f\n", totalScore);
    }
}
