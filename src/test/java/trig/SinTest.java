package trig;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class SinTest {
    private static final double delta = 0.05;
    private static final double eps = 0.001;

    private final Sin sin = new Sin();
    private static final String fileOut = "src/main/resources/csv/out/SinOut.csv";

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/SinIn.csv")
    public void testTableValues(double value, double expected) {
        double result = sin.sin(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, fileOut);
    }

    @Test
    public void testNanValue() {
        double result = sin.sin(Double.NaN, eps);
        Assertions.assertEquals(Double.NaN, sin.sin(Double.NaN, eps), delta);
        Utils.writeResToCsv(Double.NaN, result, fileOut);
    }

    @Test
    public void testPositiveInfValue() {
        double result = sin.sin(Double.POSITIVE_INFINITY, eps);
        Assertions.assertEquals(Double.POSITIVE_INFINITY, sin.sin(Double.POSITIVE_INFINITY, eps), delta);
        Utils.writeResToCsv(Double.POSITIVE_INFINITY, result, fileOut);
    }

    @Test
    public void testNegativeInfValue() {
        double result = sin.sin(Double.NEGATIVE_INFINITY, eps);
        Assertions.assertEquals(Double.NaN, sin.sin(Double.NEGATIVE_INFINITY, eps), delta);
        Utils.writeResToCsv(Double.NEGATIVE_INFINITY, result, fileOut);
    }
}
