import log.Ln;
import log.Log;
import log.UpperFunction;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import trigo.LowerFunction;
import trigo.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class FunctionTest {
    private static final double delta = 0.5;
    private static final double eps = 0.001;

    private final LowerFunction lowerFunctionMock = FunMocks.lowerFunctionMock();
    private final UpperFunction upperFunctionMock = FunMocks.upperFunctionMock();

    private final Sin sin = new Sin();
    private final Cos cos = new Cos(sin);
    private final Csc csc = new Csc(sin);
    private final Sec sec = new Sec(cos);
    private final Tan tan = new Tan(sin, cos);


    private final Ln ln = new Ln();
    private final Log log2 = new Log(ln, 2);
    private final Log log5 = new Log(ln, 5);
    private final Log log3 = new Log(ln, 3);
    private final LowerFunction lowerFunction = new LowerFunction(csc, tan, sec, cos, sin);
    private final UpperFunction upperFunction = new UpperFunction(log5, log3, log2);

    private SystemSolver function;

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/SystemIn.csv")
    public void allMockTest(double value, double expected) {
        function = new SystemSolver(lowerFunctionMock, upperFunctionMock);
        double result = function.system(value, eps);
        assertEquals(expected, result, delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/SystemIn.csv")
    public void lowerFunctionStubTest(double value, double expected) {
        function = new SystemSolver(lowerFunction, upperFunctionMock);
        double result = function.system(value, eps);
        assertEquals(expected, result, delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/SystemIn.csv")
    public void upperFunctionStubTest(double value, double expected) {
        function = new SystemSolver(lowerFunctionMock, upperFunction);
        double result = function.system(value, eps);
        assertEquals(expected, result, delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/SystemIn.csv")
    public void allStubTest(double value, double expected) {
        function = new SystemSolver(lowerFunction, upperFunction);
        double result = function.system(value, eps);
        assertEquals(expected, result, delta);
    }
}
