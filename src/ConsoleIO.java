import java.util.Scanner;

public final class ConsoleIO {
    private final Scanner scanner;

    public ConsoleIO(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readInt(String prompt, int minInclusive, int maxInclusive) {
        while (true) {
            System.out.print(prompt);
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("Please enter a valid number.");
                continue;
            }

            int value = scanner.nextInt();
            scanner.nextLine();
            if (value < minInclusive || value > maxInclusive) {
                System.out.println("Please enter a number between " + minInclusive + " and " + maxInclusive + ".");
                continue;
            }

            return value;
        }
    }

    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            }
            scanner.nextLine();
            System.out.println("Please enter a valid number.");
        }
    }
}

