package log;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpperFunction {
    private final Log log_5;
    private final Log log_3;
    private final Log log_2;


    public double system(double x, double eps) {
        return (((((log_3.log(x, eps) / log_5.log(x, eps)) / log_5.log(x, eps)) + log_2.log(x, eps)) / (log_5.log(x, eps) + (log_5.log(x, eps) * log_5.log(x, eps)))) + (Math.pow(log_2.log(x, eps), 2)));

    }
}
