package log;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class UpperFunctionTest {
    private static final double delta = 0.5;
    private static final double eps = 0.001;

    private final Log log2Mock = LogMocks.logMock("log2_in.csv");
    private final Log log3Mock = LogMocks.logMock("log3_in.csv");
    private final Log log5Mock = LogMocks.logMock("log5_in.csv");
    private final Ln ln = new Ln();
    private final Log log2 = new Log(ln, 2);
    private final Log log3 = new Log(ln, 3);
    private final Log log5 = new Log(ln, 5);


    private static final String fileOut = "src/test/resources/csv/out/upper_function_out.csv";

    private UpperFunction upperFunction;

    public UpperFunctionTest() throws IOException {
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/upper_function_in.csv")
    public void allMockTest(double value, double expected) throws IOException {
        upperFunction = new UpperFunction(log5Mock, log3Mock, log2Mock);
        double result = upperFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, fileOut);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/upper_function_in.csv")
    public void log2StubTest(double value, double expected) throws IOException {
        upperFunction = new UpperFunction(log5Mock, log3Mock, log2);
        double result = upperFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, fileOut);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/upper_function_in.csv")
    public void log5StubTest(double value, double expected) throws IOException {
        upperFunction = new UpperFunction(log5, log3Mock, log2Mock);
        double result = upperFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, fileOut);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/upper_function_in.csv")
    public void log3StubTest(double value, double expected) throws IOException {
        upperFunction = new UpperFunction(log5Mock, log3Mock, log2Mock);
        double result = upperFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, fileOut);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/upper_function_in.csv")
    public void withoutStubTest(double value, double expected) throws IOException {
        upperFunction = new UpperFunction(log5,log3,log2);
        double result = upperFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, fileOut);
    }


}
