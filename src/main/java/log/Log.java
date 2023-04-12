package log;

public class Log {
    private final Ln ln;
    private final int base;

    public Log(Ln ln, int base) {
        this.ln = ln;
        this.base = base;
    }

    public double log(double b, double eps) {
        if (Double.isNaN(ln.ln(b, eps))) return Double.NaN;
        return ln.ln(b, eps) / ln.ln(base, eps);
    }
}
