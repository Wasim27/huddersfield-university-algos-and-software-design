package unaryPredicate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsOddTest {

    /**
     * A selection of tests for IsOdd
     */

    private IsOdd predicate = new IsOdd();

    @Test
    void testZero() {
        assertFalse(predicate.test(0));
    }

    @Test
    void testOne() {
        assertTrue(predicate.test(1));
    }

    @Test
    void testTwo() {
        assertFalse(predicate.test(2));
    }

    @Test
    void testThree() {
        assertTrue(predicate.test(3));
    }

    @Test
    void testBigEven() {
        assertFalse(predicate.test(2*((Integer.MAX_VALUE-1)/2)));
    }

    @Test
    void testBigOdd() {
        assertTrue(predicate.test(2*((Integer.MAX_VALUE-1)/2)-1));
    }

    @Test
    void testMinusOne() {
        assertTrue(predicate.test(-1));
    }

    @Test
    void testMinusTwo() {
        assertFalse(predicate.test(-2));
    }

    @Test
    void testMinusThree() {
        assertTrue(predicate.test(-3));
    }

    @Test
    void testMinusBigEven() {
        assertFalse(predicate.test(2*((Integer.MIN_VALUE+1)/2)));
    }

    @Test
    void testMinusBigOdd() {
        assertTrue(predicate.test(2*((Integer.MIN_VALUE+1)/2)+1));
    }
}
