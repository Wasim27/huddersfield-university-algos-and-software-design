package scope;

public class TooSmall extends Exception {
    public TooSmall() {
        super("This scope is too small");
    }

    public TooSmall(String message) {
        super(message);
    }
}
