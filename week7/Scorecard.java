public class Scorecard {
    private final boolean[] answers;
    private int recordedCount;
    public Scorecard(int totalQuestions) {
        this.answers = new boolean[totalQuestions];
        this.recordedCount = 0;
    }
    public void recordAnswer(boolean result) {
        if (recordedCount < answers.length) {
            answers[recordedCount] = result;
            recordedCount++;
        } else {
            System.out.println("All questions already recorded. Answer ignored.");
        }
    }
    public int getScore() {
        int score = 0;
        for (int i = 0; i < recordedCount; i++) {
            if (answers[i]) {
                score++;
            }
        }
        return score;
    }
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("Total Score -> " + sc.getScore());
    }
}
