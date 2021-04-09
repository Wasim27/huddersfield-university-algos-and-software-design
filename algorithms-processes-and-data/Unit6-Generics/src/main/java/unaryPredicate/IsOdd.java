package unaryPredicate;

public class IsOdd extends CountingUnaryPredicate<Integer> {

    /**
     * Test whether a number is odd.
     *
     * @param n the number to be tested
     * @return true if n is odd
     *
     *  * @author Wasim Ramzan
     *  * @version October 2020
     */

    @Override
    public boolean test(Integer n) {
        return n % 2 != 0;
    }
}
