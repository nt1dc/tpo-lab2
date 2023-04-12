package log;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class UpperFunctionTest {
    private static final double delta = 0.5;
    private static final double eps = 0.001;
    private final Ln lnMock = LogMocks.lnMock();
    private final Log log2Mock = LogMocks.logMock("log2_in.csv");
    private final Log log5Mock = LogMocks.logMock("log5_in.csv");
    private final Log log10Mock = LogMocks.logMock("log10_in.csv");
    private final Ln ln = new Ln();
    private final Log log2 = new Log(ln, 2);
    private final Log log5 = new Log(ln, 5);
    private final Log log10 = new Log(ln, 10);

    private static final String fileOut = "src/main/resources/csv/out/upper_function_out.csv";

    private UpperFunction upperFunction;

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/upper_function_in.csv")
    public void allMockTest(double value, double expected) {
        upperFunction = new UpperFunction(lnMock, log2Mock, log5Mock, log10Mock);
        double result = upperFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, fileOut);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/upper_function_in.csv")
    public void lnStubTest(double value, double expected) {
        upperFunction = new UpperFunction(ln, log2Mock, log5Mock, log10Mock);
        double result = upperFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, fileOut);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/upper_function_in.csv")
    public void log2StubTest(double value, double expected) {
        upperFunction = new UpperFunction(lnMock, log2, log5Mock, log10Mock);
        double result = upperFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, fileOut);
    }
    

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/upper_function_in.csv")
    public void log5StubTest(double value, double expected) {
        upperFunction = new UpperFunction(lnMock, log2Mock, log5, log10Mock);
        double result = upperFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, fileOut);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/upper_function_in.csv")
    public void log10StubTest(double value, double expected) {
        upperFunction = new UpperFunction(lnMock, log2Mock, log5Mock, log10);
        double result = upperFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, fileOut);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/upper_function_in.csv")
    public void withoutStubTest(double value, double expected) {
        upperFunction = new UpperFunction(ln, log2, log5, log10);
        double result = upperFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, fileOut);
    }


}
