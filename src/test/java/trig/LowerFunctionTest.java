package trig;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import trigo.*;
import utils.Utils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class LowerFunctionTest {
    private static final double delta = 0.5;
    private static final double eps = 0.001;

    private final Sin sinMock = TriMocks.sinMock();
    private final Cos cosMock = TriMocks.cosMock();
    private final Csc cscMock = TriMocks.cscMock();
    private final Sec secMock = TriMocks.secMock();
    private final Tan tanMock = TriMocks.tanMock();


    private final Sin sin = new Sin();
    private final Cos cos = new Cos(sin);
    private final Csc csc = new Csc(sin);
    private final Sec sec = new Sec(cos);
    private final Tan tan = new Tan(sin, cos);


    private LowerFunction lowerFunction;
    private static final String file = "src/test/resources/csv/out/LeftFunctionOut.csv";

    public LowerFunctionTest() throws IOException {
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/LeftFunctionIn.csv")
    public void allMockTest(double value, double expected) throws IOException {
        lowerFunction = new LowerFunction(cscMock, tanMock, secMock, cosMock, sinMock);
        double result = lowerFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, file);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/LeftFunctionIn.csv")
    public void cosStubTest(double value, double expected) throws IOException {
        lowerFunction = new LowerFunction(cscMock, tanMock, secMock, cos, sinMock);
        double result = lowerFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, file);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/LeftFunctionIn.csv")
    public void secStubTest(double value, double expected) throws IOException {
        lowerFunction = new LowerFunction(cscMock, tanMock, sec, cosMock, sinMock);
        double result = lowerFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, file);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/LeftFunctionIn.csv")
    public void tanStubTest(double value, double expected) throws IOException {
        lowerFunction = new LowerFunction(cscMock, tan, secMock, cosMock, sinMock);
        double result = lowerFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, file);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/LeftFunctionIn.csv")
    public void sinStubTest(double value, double expected) throws IOException {
        lowerFunction = new LowerFunction(cscMock, tanMock, secMock, cosMock, sin);
        double result = lowerFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, file);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/LeftFunctionIn.csv")
    public void cscStubTest(double value, double expected) throws IOException {
        lowerFunction = new LowerFunction(csc, tanMock, secMock, cosMock, sinMock);
        double result = lowerFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, file);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/LeftFunctionIn.csv")
    public void allStubTest(double value, double expected) throws IOException {
        lowerFunction = new LowerFunction(csc, tan, sec, cos, sin);
        double result = lowerFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, file);
    }
}
