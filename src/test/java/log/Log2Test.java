package log;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class Log2Test {
    private static final double delta = 0.06;
    private static final double eps = 0.001;

    private static final Log log2 = new Log(LogMocks.lnMock(), 2);
    private static final String fileOut = "src/test/resources/csv/out/log2_out.csv";

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/log2_in.csv")
    public void testTableValues(double value, double expected) {
        double result = log2.log(value, eps);
        assertEquals(expected, result, delta);
//        Utils.writeResToCsv(value, result, fileOut);
    }

    @Test
    public void testNaNValue() throws IOException {
        double result = log2.log(Double.NaN, eps);
        assertEquals(Double.NaN, result, delta);
        Utils.writeResToCsv(Double.NaN, result, fileOut);
    }

    @Test
    public void testPositiveInfValue() throws IOException {
        double result = log2.log(Double.POSITIVE_INFINITY, eps);
        assertEquals(Double.POSITIVE_INFINITY, result, delta);
        Utils.writeResToCsv(Double.POSITIVE_INFINITY, result, fileOut);
    }

    @Test
    public void testNegativeInfValue() throws IOException {
        double result = log2.log(Double.NEGATIVE_INFINITY, eps);
        assertEquals(Double.NaN, result, delta);
        Utils.writeResToCsv(Double.NEGATIVE_INFINITY, result, fileOut);
    }
}
