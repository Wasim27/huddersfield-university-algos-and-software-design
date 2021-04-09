package timer.arrayGenerator;

import arrayGenerator.SimpleRandomListingGenerator;
import timer.timer.Timer;

/**
 * Defines a timer for SimpleRandomListingGenerators.
 *
 * @author Hugh Osborne
 * @version September 2019
 */
public class SimpleRandomListingGeneratorTimer extends SimpleRandomListingGenerator implements Timer {

    private SimpleRandomListingGeneratorTimer(int size) {
        super(size);
    }

    @Override
    public Timer getTimer(int size) {
        return new SimpleRandomListingGeneratorTimer(size);
    }

    /**
     * The method we want to time is the randomise method.
     */
    @Override
    public void timedMethod() {
        randomise();
    }

    /**
     * Cease testing once the runtime for a test excedes five seconds.
     * @return this maximum runtime.
     */
    @Override
    public long getMaximumRuntime() {
        return 5;
    }

    /**
     * Start testing at an array size of one.
     * @return this initial array size.
     */
    @Override
    public int getMinimumTaskSize() {
        return 1;
    }

    /**
     * Cease testing when the array size surpasses 10^9, whether or not the maximum runtime has been reached.
     * @return this maximum array size.
     */
    @Override
    public int getMaximumTaskSize() {
        return 1000000000;
    }

    /**
     * Run the timing sequence.
     * @param args generally not used.
     */
    public static void main(String[] args) {
        SimpleRandomListingGeneratorTimer timer = new SimpleRandomListingGeneratorTimer(0);
        timer.timingSequence();
    }
}