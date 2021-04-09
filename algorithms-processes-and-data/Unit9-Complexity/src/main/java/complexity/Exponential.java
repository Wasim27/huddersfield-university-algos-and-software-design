package complexity;

/**
 * A exponential implementation of {@link Method} (via {@link Timer}).
 *
 * @author Wasim Ramzan
 * @version October 2020
 */

public class Exponential extends Timer {

    @Override
    public void method(int n) {
        if (n == 1) {
            instruction();
        } else {
            method(n-1);
            method(n-1);
        }
    }

    @Override
    public double complexity(int n) {
        return Math.pow(2,n);
    }

    public static void main(String[] args) {
        Tester.testSequence(new Exponential(),0,args);
    }
}
