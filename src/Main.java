import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ConsoleIO io = new ConsoleIO(scanner);

            while (true) {
                System.out.println();
                System.out.println("=== Java Exam Toolkit ===");
                System.out.println("1) Generate index numbers file");
                System.out.println("2) Print weighted final grades");
                System.out.println("3) Analyze random score matrix");
                System.out.println("4) Exit");

                int choice = io.readInt("Choose an option: ", 1, 4);
                switch (choice) {
                    case 1 -> runIndexNumberGenerator(io);
                    case 2 -> runFinalGradeReport();
                    case 3 -> runScoreMatrix(io);
                    case 4 -> {
                        System.out.println("Goodbye.");
                        return;
                    }
                }
            }
        }
    }

    private static void runIndexNumberGenerator(ConsoleIO io) {
        int start = io.readInt("Start index number (e.g., 10021007): ");
        int step = io.readInt("Step (e.g., 100): ");
        int end = io.readInt("End index number (inclusive): ");
        String filename = "indexnumbers.txt";

        try {
            IndexNumberGenerator.writeRangeToFile(start, step, end, filename);
            System.out.println("Wrote index numbers to " + filename);
        } catch (IOException e) {
            System.out.println("Could not write file: " + e.getMessage());
        }
    }

    private static void runFinalGradeReport() {
        final double midRate = 0.3;
        final double examRate = 0.7;

        int[] studentIds = {10021007, 10021107, 10021207, 10021307, 10021407, 10021507, 10021607, 10021707, 10021807, 10021907, 10022007, 10022107, 10022207, 10022307, 10022407};
        int[] midSem = {65, 48, 22, 32, 80, 12, 45, 25, 33, 67, 23, 45, 56, 34, 81};
        int[] exam = {78, 54, 90, 32, 66, 60, 45, 65, 45, 58, 33, 45, 67, 90, 67};

        System.out.println();
        FinalGradeReport.printWeightedFinalGrades(studentIds, midSem, exam, midRate, examRate);
    }

    private static void runScoreMatrix(ConsoleIO io) {
        int students = io.readInt("Number of students: ", 1, 200);
        int subjects = io.readInt("Number of subjects: ", 1, 50);

        int[][] scores = ScoreMatrixAnalyzer.randomScores(students, subjects, System.currentTimeMillis());
        System.out.println();
        ScoreMatrixAnalyzer.printReport(scores);

        System.out.println();
        int studentNumber = io.readInt("Enter a student number to view their scores: ", 1, students);
        ScoreMatrixAnalyzer.printStudentScores(scores, studentNumber);
    }
}

