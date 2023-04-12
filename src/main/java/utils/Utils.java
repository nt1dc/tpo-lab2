package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Utils {
    public static void writeResToCsv(double x, double res, String fileOut) throws IOException {
        String text = x + "," + res + "\n";
        Files.write(Paths.get(fileOut), text.getBytes(), StandardOpenOption.APPEND);

    }
}
