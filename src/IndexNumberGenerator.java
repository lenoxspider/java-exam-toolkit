import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public final class IndexNumberGenerator {
    private IndexNumberGenerator() {}

    public static void writeRangeToFile(int start, int step, int endInclusive, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false))) {
            for (int value = start; value <= endInclusive; value += step) {
                writer.write(Integer.toString(value));
                writer.newLine();
            }
        }
    }
}

