import log.UpperFunction;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import trigo.LowerFunction;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FunMocks {
    private static final double eps = 0.001;

    public static LowerFunction lowerFunctionMock() {
        LowerFunction lowerFunctionMock = Mockito.mock(LowerFunction.class);
        try {
            Reader lnIn = new FileReader("src/test/resources/csv/in/LeftFunctionIn.csv");

            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(lnIn);
            records.forEach(record -> Mockito.when(lowerFunctionMock.system(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1))));
            Mockito.when(lowerFunctionMock.system(Double.NaN, eps)).thenReturn(Double.NaN);
            Mockito.when(lowerFunctionMock.system(Double.POSITIVE_INFINITY, eps)).thenReturn(Double.POSITIVE_INFINITY);
            Mockito.when(lowerFunctionMock.system(Double.NEGATIVE_INFINITY, eps)).thenReturn(Double.NaN);
        } catch (IOException e) {
            System.err.println("No such file");
        }
        return lowerFunctionMock;
    }

    public static UpperFunction upperFunctionMock() {
        UpperFunction upperFunctionMock = Mockito.mock(UpperFunction.class);
        try {
            Reader lnIn = new FileReader("src/test/resources/csv/in/upper_function_in.csv");
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(lnIn);
            records.forEach(record -> Mockito.when(upperFunctionMock.system(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1))));
            Mockito.when(upperFunctionMock.system(Double.NaN, eps)).thenReturn(Double.NaN);
            Mockito.when(upperFunctionMock.system(Double.POSITIVE_INFINITY, eps)).thenReturn(Double.POSITIVE_INFINITY);
            Mockito.when(upperFunctionMock.system(Double.NEGATIVE_INFINITY, eps)).thenReturn(Double.NaN);
        } catch (IOException e) {
            System.err.println("No such file");
        }
        return upperFunctionMock;
    }

}
