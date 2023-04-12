import log.UpperFunction;
import trigo.LowerFunction;

public class SystemSolver {
    private final LowerFunction lowerFunction;
    private final UpperFunction upperFunction;

    public SystemSolver(LowerFunction lowerFunction, UpperFunction upperFunction) {
        this.lowerFunction = lowerFunction;
        this.upperFunction = upperFunction;
    }

    public double system(double x, double eps) {
        if (x <= 0) {
            return lowerFunction.system(x, eps);
        } else {
            return upperFunction.system(x, eps);
        }
    }
}
