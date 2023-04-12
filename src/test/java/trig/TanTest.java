package trig;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class TanTest {
    private static final double delta = 0.05;
    private static final double eps = 0.001;

    private final Tan tan = new Tan(TriMocks.cosMock(), TriMocks.sinMock());
    private static final String fileOut = "src/main/resources/csv/out/TanOut.csv";

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/TanIn.csv")
    public void testTableValues(double value, double expected) {
        double result = tan.tan(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, fileOut);
    }

    @Test
    public void testNanValue() {
        double result = tan.tan(Double.NaN, eps);
        assertEquals(Double.NaN, result, delta);
        Utils.writeResToCsv(Double.NaN, result, fileOut);
    }

    @Test
    public void testPositiveInfValue() {
        double result = tan.tan(Double.POSITIVE_INFINITY, eps);
        Assertions.assertEquals(Double.POSITIVE_INFINITY, result, delta);
        Utils.writeResToCsv(Double.POSITIVE_INFINITY, result, fileOut);
    }

    @Test
    public void testNegativeInfValue() {
        double result = tan.tan(Double.NEGATIVE_INFINITY, eps);
        Assertions.assertEquals(Double.NaN, result, delta);
        Utils.writeResToCsv(Double.NEGATIVE_INFINITY, result, fileOut);
    }
}
