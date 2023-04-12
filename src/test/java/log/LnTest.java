package log;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class LnTest {
    private static final double delta = 0.06;
    private static final double eps = 0.001;
    private final Ln ln = new Ln();
    private static final String fileOut = "src/main/resources/csv/out/ln_out.csv";

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/ln_in.csv")
    public void testTableValues(double value, double expected) {
        double result = ln.ln(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, fileOut);
    }

    @Test
    public void testNanValue() {
        double result = ln.ln(Double.NaN, eps);
        Assertions.assertEquals(Double.NaN, result, delta);
        Utils.writeResToCsv(Double.NaN, result, fileOut);
    }

    @Test
    public void testPositiveInfValue() {
        double result = ln.ln(Double.POSITIVE_INFINITY, eps);
        Assertions.assertEquals(Double.POSITIVE_INFINITY, result, delta);
        Utils.writeResToCsv(Double.POSITIVE_INFINITY, result, fileOut);
    }

    @Test
    public void testNegativeInfValue() {
        double result = ln.ln(Double.NEGATIVE_INFINITY, eps);
        Assertions.assertEquals(Double.NaN, result, delta);
        Utils.writeResToCsv(Double.NEGATIVE_INFINITY, result, fileOut);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-2, -5, -12, -111})
    public void testNegativeValues(double value) {
        double result = ln.ln(value, eps);
        Assertions.assertEquals(Double.NaN, result, delta);
        Utils.writeResToCsv(Double.NaN, result, fileOut);
    }
}
