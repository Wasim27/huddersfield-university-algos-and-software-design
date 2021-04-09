package scope;

/**
 * An implementation of a Scope for Strings.
 *
 * @author Hugh Osborne
 * @version October 2020
 */

public class StringScope implements Scope<String> {
    // the character generator for this scope
    private CharacterScope characterGenerator;
    // the string length generator for this scope
    private IntegerScope lengthGenerator;

    /**
     * @param alphabet the alphabet of this scope.
     * @param maxLength the maximum string length for this scope.
     */
    public StringScope(String alphabet,int maxLength) {
        characterGenerator = new CharacterScope(alphabet);
        lengthGenerator = new IntegerScope(0,maxLength);
    }

    /**
     * Construct a StringScope using CharacterScope's default alphabet as the alphabet.
     * @param maxLength the maximum string length for this scope.
     */
    public StringScope(int maxLength) {
        characterGenerator = new CharacterScope();
        lengthGenerator = new IntegerScope(0,maxLength);
    }

    /**
     * A String is within the scope if:
     * <ul>
     *     <li> it is of the right length (within the scope of the length generator</li>
     *     <li> all of its characters are in its alphabet (within the scope of the character generator</li>
     * </ul>
     * @param value the value to be checked.
     * @return true iff the String is within the this scope.
     */
    @Override
    public boolean contains(String value) {
        if (!lengthGenerator.contains(value.length())) {
            return false;
        }
        for (char character: value.toCharArray()) {
            if (!characterGenerator.contains(character)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Build a String from this scope.
     * @return a String within this scope/
     */
    @Override
    public String getValue() {
        int size = lengthGenerator.getValue();
        char[] characters = new char[size];
        for (int index = 0; index < characters.length; index++) {
            characters[index] = characterGenerator.getValue();
        }
        return new String(characters);
    }

    /**
     * Calculate the number of Strings in this scope.
     * The number of Strings in the scope is the sum of a geometric series.  If the alphabet contains c characters,
     * then there is one string of length zero, c strings of length one, c<sup>2</sup> strings of length 2, etc.  So,
     * if the maximum string length is n, we have 1+c+c<sup>2</sup>+...+c<sup>n</sup> which is
     * c<sup>n+1</sup>&frasl;<sub>c-1</sub>.
     * @return the number of Strings in this scope.
     */
    @Override
    public int size() {
        int c = characterGenerator.size();
        int n = lengthGenerator.size(); // is already n+1
        return ((int) Math.pow(c,n))/(c-1);
    }
}
