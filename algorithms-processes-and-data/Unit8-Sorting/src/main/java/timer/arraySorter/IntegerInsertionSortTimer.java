package timer.arraySorter;

import arrayGenerator.ArrayGenerator;
import arrayGenerator.IntegerArrayGenerator;
import scope.IntegerScope;
import timer.timer.Timer;

public class IntegerInsertionSortTimer extends InsertionSortTimer<Integer> {
    @Override
    public Timer getTimer(int size) {
        ArrayGenerator<Integer> generator = new IntegerArrayGenerator(new IntegerScope());
        setArray(generator.getArray(size));
        return this;
    }
    public static void main(String[] args) {
        InsertionSortTimer<Integer> timer = new IntegerInsertionSortTimer();
        timer.timingSequence(false); // short (spreadsheet) output
    }
}
