package trig;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import trigo.*;
import utils.Utils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class CosTest {
    private static final double delta = 0.05;
    private static final double eps = 0.001;

    private final Cos cos = new Cos(TriMocks.sinMock());
    private static final String fileOut = "src/test/resources/csv/out/CosOut.csv";

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/CosIn.csv")
    public void testTableValues(double value, double expected) throws IOException {
        double result = cos.cos(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, fileOut);
    }

    @Test
    public void testNanValue() throws IOException {
        double result = cos.cos(Double.NaN, eps);
        assertEquals(Double.NaN, result, delta);
        Utils.writeResToCsv(Double.NaN, result, fileOut);
    }

    @Test
    public void testPositiveInfValue() throws IOException {
        double result = cos.cos(Double.POSITIVE_INFINITY, eps);
        Assertions.assertEquals(Double.POSITIVE_INFINITY, result, delta);
        Utils.writeResToCsv(Double.POSITIVE_INFINITY, result, fileOut);
    }

    @Test
    public void testNegativeInfValue() throws IOException {
        double result = cos.cos(Double.NEGATIVE_INFINITY, eps);
        Assertions.assertEquals(Double.NaN, result, delta);
        Utils.writeResToCsv(Double.NEGATIVE_INFINITY, result, fileOut);
    }
}
