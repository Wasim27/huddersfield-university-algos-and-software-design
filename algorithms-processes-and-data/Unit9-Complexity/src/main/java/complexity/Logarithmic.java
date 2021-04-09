package complexity;

/**
 * A logarithmic implementation of {@link Method} (via {@link Timer}).
 *
 * @author Wasim Ramzan
 * @version October 2020
 */

public class Logarithmic extends Timer {

    @Override
    public void method(int n) {
        for(int i = 1; i < n; i = i * 2) {
            instruction();
        }
    }

    @Override
    public double complexity(int n) {
        return Math.log(n);
    }

    public static void main(String[] args) {
        Tester.testSequence(new Logarithmic(),0,args);
    }
}
