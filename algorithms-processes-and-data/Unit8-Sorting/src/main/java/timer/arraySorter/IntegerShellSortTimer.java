package timer.arraySorter;

import arrayGenerator.ArrayGenerator;
import arrayGenerator.IntegerArrayGenerator;
import scope.IntegerScope;
import timer.timer.Timer;

public class IntegerShellSortTimer extends ShellSortTimer<Integer> {

    public Timer getTimer(int size) {
        ArrayGenerator<Integer> generator = new IntegerArrayGenerator(new IntegerScope());
        setArray(generator.getArray(size));
        return this;
    }
    public static void main(String[] args) {
        ShellSortTimer<Integer> timer = new IntegerShellSortTimer();
        timer.timingSequence(false); // short (spreadsheet) output
    }
}
