package trigo;

public class Sec {
    private final Cos cos;

    public Sec(Cos cos) {
        this.cos = cos;
    }

    public double sec(double x, double eps) {
        double cosVal = cos.cos(x, eps);
        if (Double.POSITIVE_INFINITY == cosVal) return Double.POSITIVE_INFINITY;
        if (Double.isNaN(cosVal) || cosVal == Double.NEGATIVE_INFINITY) return Double.NaN;
        if (Math.abs(cosVal) <= eps * 5) return Double.POSITIVE_INFINITY;
        return 1 / cosVal;
    }
}
