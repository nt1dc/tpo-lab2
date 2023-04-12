package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Utils {
    public static void writeResToCsv(double x, double res, String fileOut) {
        String text = x + "," + res + "\n";
        try {
            Files.write(Paths.get(fileOut), text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Не удалось записать в файл");
        }
    }
}
