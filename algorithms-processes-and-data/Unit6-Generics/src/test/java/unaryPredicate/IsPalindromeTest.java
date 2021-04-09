package unaryPredicate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsPalindromeTest {

    /**
     * A selection of tests for IsPalindrome
     */

    IsPalindrome predicate = new IsPalindrome();

    @Test
    void testStrings(){
        assertTrue(predicate.test("mum"));
        assertTrue(predicate.test("naan"));
        assertTrue(predicate.test("radar"));
        assertTrue(predicate.test("rotator"));
    }

    @Test
    void testCapital(){
        assertTrue(predicate.test("Malayalam"));
        assertTrue(predicate.test("RoTatOr"));
        assertTrue(predicate.test("deTaRtraTED"));
    }

    @Test
    void testPunctuationAndSpaces(){
        assertTrue(predicate.test("God's dog"));
        assertTrue(predicate.test("Able was I ere I saw Elba"));
        assertTrue(predicate.test("A man, a plan, a canal --- panama!"));
    }

    @Test
    void testNumbers(){
        assertTrue(predicate.test("1234321"));
        assertTrue(predicate.test("1001rotaTor"));
    }

    @Test
    void testNonPalindrome(){
        assertFalse(predicate.test("thisisnotapalindrome"));
        assertFalse(predicate.test("HELLO WORLD 2020"));
        assertFalse(predicate.test("abc123"));
    }
}
