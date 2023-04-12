package trigo;

public class Csc {
    private final Sin sin;

    public Csc(Sin sin) {
        this.sin = sin;
    }

    public double csc(double x, double eps) {
        double sinVal = sin.sin(x, eps);
        if (Double.POSITIVE_INFINITY == sinVal) return Double.POSITIVE_INFINITY;
        if (Double.isNaN(sinVal) || Double.NEGATIVE_INFINITY == sinVal) return Double.NaN;
        return 1 / sinVal;
    }
}