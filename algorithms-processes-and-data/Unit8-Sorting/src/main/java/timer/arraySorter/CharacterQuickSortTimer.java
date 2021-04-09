package timer.arraySorter;

import arrayGenerator.ArrayGenerator;
import arrayGenerator.CharacterArrayGenerator;
import timer.timer.Timer;

public class CharacterQuickSortTimer extends QuickSortTimer<Character> {

    @Override
    public Timer getTimer(int size) {
        ArrayGenerator<Character> generator = new CharacterArrayGenerator();
        setArray(generator.getArray(size));
        return this;
    }

    public static void main(String[] args) {
        QuickSortTimer<Character> timer = new CharacterQuickSortTimer();
        timer.timingSequence(true); // long output
    }
}