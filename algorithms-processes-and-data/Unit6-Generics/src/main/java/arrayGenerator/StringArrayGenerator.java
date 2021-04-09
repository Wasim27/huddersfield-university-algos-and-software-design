package arrayGenerator;

import scope.Scope;
import scope.StringScope;

public class StringArrayGenerator extends ScopedArrayGenerator<String> {
    /**
     * Constructor where the alphabet is provided.
     *
     * @param scope the scope of the characters permitted for this generator.
     */
    public StringArrayGenerator(Scope<String> scope)
    {
        super(scope);
    }

    /**
     * If no alphabet is provided, use the default alphabet provided by {@link StringScope}.
     * @param length the maximum length of strings to generate.
     */
    public StringArrayGenerator(int length) {
        super(new StringScope(length));
    }

    /**
     * A createArray method is required for each non-generic class implementing the generic
     * {@link ScopedArrayGenerator} class with a specific type.  This is because we cannot
     * create generic arrays in Java (e.g. <tt>T[] array = <b>new</b> T[size]</tt>).
     * @param size the size of the array to be created
     * @return an array of {@link String}s of the required size.  The values of the Characters
     *         will be uninstantiated.
     */
    @Override
    String[] createArray(int size) {
        return new String[size];
    }
}
