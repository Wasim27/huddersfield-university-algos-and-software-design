package complexity;

/**
 * A cubic implementation of {@link Method} (via {@link Timer}).
 *
 * @author Wasim Ramzan
 * @version October 2020
 */

public class Cubic extends Timer {

    @Override
    public void method(int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    instruction();
                }
            }
        }
    }

    @Override
    public double complexity(int n) {
        return Math.pow(n,3);
    }

    public static void main(String[] args) {
        Tester.testSequence(new Cubic(),0,args);
    }
}
