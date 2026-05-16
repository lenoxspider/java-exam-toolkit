import java.util.Random;

public final class ScoreMatrixAnalyzer {
    private ScoreMatrixAnalyzer() {}

    public static int[][] randomScores(int students, int subjects, long seed) {
        Random random = new Random(seed);
        int[][] scores = new int[students][subjects];
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < subjects; j++) {
                scores[i][j] = random.nextInt(101);
            }
        }
        return scores;
    }

    public static void printReport(int[][] scores) {
        int students = scores.length;
        int subjects = students == 0 ? 0 : scores[0].length;

        int highest = Integer.MIN_VALUE;
        int highestStudent = -1;
        int highestSubject = -1;
        int[] gradeCounts = new int[5]; // A,B,C,D,F

        for (int i = 0; i < students; i++) {
            int sum = 0;
            System.out.print("Student " + (i + 1) + ":");
            for (int j = 0; j < subjects; j++) {
                int score = scores[i][j];
                System.out.print(" " + score);
                sum += score;

                if (score > highest) {
                    highest = score;
                    highestStudent = i + 1;
                    highestSubject = j + 1;
                }

                char grade = GradeScale.letter(score);
                switch (grade) {
                    case 'A' -> gradeCounts[0]++;
                    case 'B' -> gradeCounts[1]++;
                    case 'C' -> gradeCounts[2]++;
                    case 'D' -> gradeCounts[3]++;
                    default -> gradeCounts[4]++;
                }
            }
            double average = subjects == 0 ? 0.0 : (double) sum / subjects;
            System.out.printf(" | Total: %d | Avg: %.2f%n", sum, average);
        }

        System.out.println();
        if (highestStudent != -1) {
            System.out.println("Highest score: " + highest);
            System.out.println("Found at Student " + highestStudent + ", Subject " + highestSubject);
        }

        System.out.println();
        System.out.println("Grade Distribution:");
        System.out.println("A: " + gradeCounts[0]);
        System.out.println("B: " + gradeCounts[1]);
        System.out.println("C: " + gradeCounts[2]);
        System.out.println("D: " + gradeCounts[3]);
        System.out.println("F: " + gradeCounts[4]);
    }

    public static void printStudentScores(int[][] scores, int studentNumber) {
        if (studentNumber < 1 || studentNumber > scores.length) {
            throw new IllegalArgumentException("studentNumber out of range.");
        }
        int[] row = scores[studentNumber - 1];
        System.out.print("Student " + studentNumber + " scores:");
        for (int score : row) {
            System.out.print(" " + score);
        }
        System.out.println();
    }
}

