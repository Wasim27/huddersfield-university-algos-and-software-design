public class IntBox {
    private int value;
    private IntBox box;

    public IntBox(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return "[" + value + "]";
    }
}
