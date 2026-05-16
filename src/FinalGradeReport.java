public final class FinalGradeReport {
    private FinalGradeReport() {}

    public static void printWeightedFinalGrades(int[] studentIds, int[] midSem, int[] exam, double midRate, double examRate) {
        if (studentIds.length != midSem.length || midSem.length != exam.length) {
            throw new IllegalArgumentException("Input arrays must have the same length.");
        }
        if (Math.abs((midRate + examRate) - 1.0) > 1e-9) {
            throw new IllegalArgumentException("midRate + examRate must equal 1.0");
        }

        System.out.println("| Index No. | Final Score | Grade |");
        System.out.println("|----------|------------:|:-----:|");

        for (int i = 0; i < studentIds.length; i++) {
            double finalScore = (midRate * midSem[i]) + (examRate * exam[i]);
            char grade = GradeScale.letter(finalScore);
            System.out.printf("| %d | %.2f | %c |%n", studentIds[i], finalScore, grade);
        }
    }
}

