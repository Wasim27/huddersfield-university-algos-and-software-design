package unaryPredicate;

public class IsPrime extends CountingUnaryPredicate<Integer> {

    /**
     * Test whether a number is prime.
     *
     * @param n the number to be tested
     * @return true if n is prime
     *
     *  @author Wasim Ramzan
     *  @version October 2020
     */

    @Override
    public boolean test(Integer n) {
        boolean isPrime = true;

        if (n < 2) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
