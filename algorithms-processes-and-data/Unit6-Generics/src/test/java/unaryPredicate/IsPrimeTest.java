package unaryPredicate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsPrimeTest {

    /**
     * A selection of tests for IsPrime
     */

    private IsPrime predicate = new IsPrime();

    @Test
    void testZero(){
        assertFalse(predicate.test(0));
    }

    @Test
    void testOne() {
        assertFalse(predicate.test(1));
    }

    @Test
    void testTwo() {
        assertTrue(predicate.test(2));
    }

    @Test
    void testThree() {
        assertTrue(predicate.test(3));
    }

    @Test
    void testLargestUnder1000(){
        assertTrue(predicate.test(997));
    }

    @Test
    void testMinusTwo() {
        assertFalse(predicate.test(-2));
    }

    @Test
    void testLargestUnderMinus1000() {
        assertFalse(predicate.test(-997));
    }
}
