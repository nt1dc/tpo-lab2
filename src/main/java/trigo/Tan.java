package trigo;

public class Tan {
    private final Sin sin;
    private final Cos cos;

    public Tan(Sin sin, Cos cos) {
        this.sin = sin;
        this.cos = cos;
    }

    public double tan(double x, double eps) {
        double cosVal = cos.cos(x, eps);
        double sinVal = sin.sin(x, eps);
        if (Double.POSITIVE_INFINITY == cosVal || Double.POSITIVE_INFINITY == sinVal) return Double.POSITIVE_INFINITY;
        if (Double.isNaN(cosVal) || cosVal == Double.NEGATIVE_INFINITY ||
                Double.isNaN(sinVal) || sinVal == Double.NEGATIVE_INFINITY) return Double.NaN;
        return sinVal / cosVal;
    }
}
