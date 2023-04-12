package trigo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LowerFunction{
    private final Csc csc;
    private final Tan tan;
    private final Sec sec;
    private final Cos cos;
    private final Sin sin;

    public double system(double x, double eps) {
        return ((((
                Math.pow(Math.pow(csc.csc(x, eps) / csc.csc(x, eps), 3), 3)
                        * (tan.tan(x, eps) / sec.sec(x, eps))) * cos.cos(x, eps)) + sec.sec(x, eps)) - ((csc.csc(x, eps) - tan.tan(x, eps)) - ((cos.cos(x, eps) + cos.cos(x, eps)) - sin.sin(x, eps))));
    }
}
