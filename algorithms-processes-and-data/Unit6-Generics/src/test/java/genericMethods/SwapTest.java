package genericMethods;

import arrayGenerator.ArrayGenerator;
import arrayGenerator.CharacterArrayGenerator;
import arrayGenerator.IntegerArrayGenerator;
import arrayGenerator.StringArrayGenerator;
import org.junit.jupiter.api.Test;
import scope.CharacterScope;
import scope.IntegerScope;
import scope.StringScope;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SwapTest {

    private static final int MAX_STRING_SIZE = 100;

    private Random random = new Random();

    private <T> void test(ArrayGenerator<T> generator,int arraySize) {
        T[] array = generator.getArray(random.nextInt(arraySize - 1) + 1);
        int index1 = random.nextInt(array.length);
        int index2 = random.nextInt(array.length);
        testArray(array, index1, index2);
    }

    private <T> void testSame(ArrayGenerator<T> generator,int arraySize) {
        T[] array = generator.getArray(random.nextInt(arraySize - 1) + 1);
        int index = random.nextInt(array.length);
        testArray(array, index, index);
    }

    private <T> void testLimits(ArrayGenerator<T> generator,int arraySize) {
        T[] array = generator.getArray(random.nextInt(arraySize - 1) + 1);
        testArray(array, 0, array.length-1);
    }

    private <T> void testNegativeIndex(ArrayGenerator<T> generator,int arraySize) {
        T[] array = generator.getArray(random.nextInt(arraySize - 1) + 1);
        int index = random.nextInt(array.length);
        testOutOfBounds(array, -1, array.length-1);
    }

    private <T> void testLargeIndex(ArrayGenerator<T> generator,int arraySize) {
        T[] array = generator.getArray(random.nextInt(arraySize - 1) + 1);
        int index = random.nextInt(array.length);
        testOutOfBounds(array, index, array.length);
    }

    private <T> void testArray(T[] array,int index1,int index2) {
        T[] oldArray = Arrays.copyOf(array,array.length);
        Swap.swap(array,index1,index2);
        assertEquals(oldArray[index2],array[index1],"Entry at " + index1 + " has not been swapped with entry at " + index2);
        assertEquals(oldArray[index1],array[index2],"Entry at " + index2 + " has not been swapped with entry at " + index1);
        for (int index = 0; index < array.length; index++) {
            if (index != index1 && index != index2) {
                assertEquals(oldArray[index],array[index],"Entry at " + index + " has changed");
            }
        }
    }

    private <T> void testOutOfBounds(T[] array,int index1,int index2) {
        assertThrows(ArrayIndexOutOfBoundsException.class,()->Swap.swap(array,index1,index2));
    }

    @Test
    public void testSmallInt() {
        test(new IntegerArrayGenerator(new IntegerScope(0,10)),10);
    }

    @Test
    public void testSmallString() {
        test(new StringArrayGenerator(new StringScope(10)),10);
    }

    @Test
    public void testSmallCharacter() {
        test(new CharacterArrayGenerator(new CharacterScope()),10);
    }

    @Test
    public void testMediumInt() {
        test(new IntegerArrayGenerator(new IntegerScope(0,10)),100);
    }

    @Test
    public void testMediumString() {
        test(new StringArrayGenerator(new StringScope(10)),100);
    }

    @Test
    public void testMediumCharacter() {
        test(new CharacterArrayGenerator(new CharacterScope()),100);
    }

    @Test
    public void testLargeInt() {
        test(new IntegerArrayGenerator(new IntegerScope(0,10)),1000);
    }

    @Test
    public void testLargeString() {
        test(new StringArrayGenerator(new StringScope(10)),1000);
    }

    @Test
    public void testLargeCharacter() {
        test(new CharacterArrayGenerator(new CharacterScope()),1000);
    }

    @Test
    public void testHomogenousInt() {
        test(new IntegerArrayGenerator(new IntegerScope(5,5)),25);
    }

    @Test
    public void testHomogenousCharacter() {
        test(new CharacterArrayGenerator(new CharacterScope("q")),25);
    }

    @Test
    public void testSmallSame() {
        testSame(new IntegerArrayGenerator(new IntegerScope(0,10)),10);
    }

    @Test
    public void testMediumSame() {
        testSame(new CharacterArrayGenerator(new CharacterScope()),100);
    }

    @Test
    public void testLargeSame() {
        testSame(new StringArrayGenerator(new StringScope(10)),1000);
    }

    @Test
    public void testSmallLimits() {
        testLimits(new StringArrayGenerator(new StringScope(10)),10);
    }

    @Test
    public void testMediumLimits() {
        testLimits(new IntegerArrayGenerator(new IntegerScope(0,10)),100);
    }

    @Test
    public void testLargeLimits() {
        testLimits(new CharacterArrayGenerator(new CharacterScope()),1000);
    }

    @Test
    public void testSmallNegativeIndex() {
        testNegativeIndex(new IntegerArrayGenerator(new IntegerScope(0,10)),10);
    }

    @Test
    public void testMediumNegativeIndex() {
        testNegativeIndex(new StringArrayGenerator(new StringScope(10)),100);
    }

    @Test
    public void testLargeNegativeIndex() {
        testNegativeIndex(new CharacterArrayGenerator(new CharacterScope()),1000);
    }

    @Test
    public void testSmallLargeIndex() {
        testLargeIndex(new StringArrayGenerator(new StringScope(10)),10);
    }

    @Test
    public void testMediumLargeIndex() {
        testLargeIndex(new IntegerArrayGenerator(new IntegerScope(0,10)),100);
    }

    @Test
    public void testLargeLargeIndex() {
        testLargeIndex(new CharacterArrayGenerator(new CharacterScope()),1000);
    }

    @Test
    public void testEmpty() {
        assertThrows(ArrayIndexOutOfBoundsException.class,()->Swap.swap(new Integer[0],0,0));
    }

    @Test
    public void testNull() {
        assertThrows(NullPointerException.class,()->Swap.swap(null,0,0));
    }
}