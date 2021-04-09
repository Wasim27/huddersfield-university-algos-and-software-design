import java.util.Arrays;

public class Pointers {
    private static void callByValue(int x,int y) {
        x = 10;
        y = 100;
        System.out.println("x = " + x + ", y = " + y);
    }

    private static void callByName(IntBox boxX,IntBox boxY) {
        boxX.setValue(10);
        boxY.setValue(100);
        System.out.println("boxX is " + boxX + ", boxY is " + boxY);
    }

    public static void main(String[] args) {
        IntBox[] array = {new IntBox(15),new IntBox(5)};
        IntBox[] arrayCopy = array;
        array[0].setValue(10);
        array[1].setValue(100);
        System.out.println("Array is " + Arrays.toString(array));
    }
}
