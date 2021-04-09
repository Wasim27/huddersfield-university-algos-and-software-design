package complexity;

/**
 * A quadratic implementation of {@link Method} (via {@link Timer}).
 *
 * @author Wasim Ramzan
 * @version October 2020
 */

public class Quadratic extends Timer {
    @Override
    public void method(int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                instruction();
            }
        }
    }

    @Override
    public double complexity(int n) {
        return n*n;
    }

    public static void main(String[] args) {
        Tester.testSequence(new Quadratic(),0,args);
    }
}
