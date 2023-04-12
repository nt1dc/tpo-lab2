package trig;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.mockito.Mockito;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TriMocks {
    private static final double eps = 0.001;

    public static Sin sinMock() {
        Sin sinMock = Mockito.mock(Sin.class);
        try {
            Reader lnIn = new FileReader("src/main/resources/csv/in/SinIn.csv");
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(lnIn);
            records.forEach(record -> Mockito.when(sinMock.sin(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1))));
            Mockito.when(sinMock.sin(Double.NaN, eps)).thenReturn(Double.NaN);
            Mockito.when(sinMock.sin(Double.POSITIVE_INFINITY, eps)).thenReturn(Double.POSITIVE_INFINITY);
            Mockito.when(sinMock.sin(Double.NEGATIVE_INFINITY, eps)).thenReturn(Double.NaN);
        } catch (IOException e) {
            System.err.println("No such file");
        }
        return sinMock;
    }

    public static Cos cosMock() {
        Cos cosMock = Mockito.mock(Cos.class);
        try {
            Reader lnIn = new FileReader("src/main/resources/csv/in/CosIn.csv");
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(lnIn);
            records.forEach(record -> Mockito.when(cosMock.cos(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1))));
            Mockito.when(cosMock.cos(Double.NaN, eps)).thenReturn(Double.NaN);
            Mockito.when(cosMock.cos(Double.POSITIVE_INFINITY, eps)).thenReturn(Double.POSITIVE_INFINITY);
            Mockito.when(cosMock.cos(Double.NEGATIVE_INFINITY, eps)).thenReturn(Double.NaN);
        } catch (IOException e) {
            System.err.println("No such file");
        }
        return cosMock;
    }

    public static Csc cscMock() {
        Csc cscMock = Mockito.mock(Csc.class);
        try {
            Reader lnIn = new FileReader("src/main/resources/csv/in/CscIn.csv");
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(lnIn);
            records.forEach(record -> Mockito.when(cscMock.csc(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1))));
            Mockito.when(cscMock.csc(Double.NaN, eps)).thenReturn(Double.NaN);
            Mockito.when(cscMock.csc(Double.POSITIVE_INFINITY, eps)).thenReturn(Double.POSITIVE_INFINITY);
            Mockito.when(cscMock.csc(Double.NEGATIVE_INFINITY, eps)).thenReturn(Double.NaN);
        } catch (IOException e) {
            System.err.println("No such file");
        }
        return cscMock;
    }

    public static Sec secMock() {
        Sec secMock = Mockito.mock(Sec.class);
        try {
            Reader lnIn = new FileReader("src/main/resources/csv/in/SecIn.csv");
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(lnIn);
            records.forEach(record -> Mockito.when(secMock.sec(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1))));
            Mockito.when(secMock.sec(Double.NaN, eps)).thenReturn(Double.NaN);
            Mockito.when(secMock.sec(Double.POSITIVE_INFINITY, eps)).thenReturn(Double.POSITIVE_INFINITY);
            Mockito.when(secMock.sec(Double.NEGATIVE_INFINITY, eps)).thenReturn(Double.NaN);
        } catch (IOException e) {
            System.err.println("No such file");
        }
        return secMock;
    }

    public static Tan tanMock() {
        Tan tanMock = Mockito.mock(Tan.class);
        try {
            Reader lnIn = new FileReader("src/main/resources/csv/in/TanIn.csv");
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(lnIn);
            records.forEach(record -> Mockito.when(tanMock.tan(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1))));
            Mockito.when(tanMock.tan(Double.NaN, eps)).thenReturn(Double.NaN);
            Mockito.when(tanMock.tan(Double.POSITIVE_INFINITY, eps)).thenReturn(Double.POSITIVE_INFINITY);
            Mockito.when(tanMock.tan(Double.NEGATIVE_INFINITY, eps)).thenReturn(Double.NaN);
        } catch (IOException e) {
            System.err.println("No such file");
        }
        return tanMock;
    }

    public static Cot cotMock() {
        Cot cotMock = Mockito.mock(Cot.class);
        try {
            Reader lnIn = new FileReader("src/main/resources/csv/in/CotIn.csv");
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(lnIn);
            records.forEach(record -> Mockito.when(cotMock.cot(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1))));
            Mockito.when(cotMock.cot(Double.NaN, eps)).thenReturn(Double.NaN);
            Mockito.when(cotMock.cot(Double.POSITIVE_INFINITY, eps)).thenReturn(Double.POSITIVE_INFINITY);
            Mockito.when(cotMock.cot(Double.NEGATIVE_INFINITY, eps)).thenReturn(Double.NaN);
        } catch (IOException e) {
            System.err.println("No such file");
        }
        return cotMock;
    }
}
