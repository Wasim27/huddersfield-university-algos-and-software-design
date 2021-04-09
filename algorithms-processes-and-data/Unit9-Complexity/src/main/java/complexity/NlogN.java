package complexity;

/**
 * A NlogN implementation of {@link Method} (via {@link Timer}).
 *
 * @author Wasim Ramzan
 * @version October 2020
 */

public class NlogN extends Timer {

    @Override
    public void method(int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < n; j = j * 2) {
                instruction();
            }
        }
    }

    @Override
    public double complexity(int n) {
        return n * Math.log(n);
    }

    public static void main(String[] args) {
        Tester.testSequence(new NlogN(),0,args);
    }
}
