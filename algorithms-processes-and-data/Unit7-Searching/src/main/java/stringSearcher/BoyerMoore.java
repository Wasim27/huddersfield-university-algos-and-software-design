package stringSearcher;

public class BoyerMoore extends StringSearcher {

    private int[] right;
    private String pat;

    public BoyerMoore(char[] string) {
        super(string);
    }

    public BoyerMoore(String pat) {
        super(pat);
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        right = new int[R];
        for (int c = 0; c < R; c++) {
            right[c] = -1;
            for (int j = 0; j < M; j++) {
                right[pat.charAt(j)] = j;
            }
        }
    }

    @Override
    public int occursIn(char[] superstring) throws NotFound {
        int N = superstring.length;
        int M = pat.length();
        int skip;
        for (int i = 0; i <= N - M; i += skip) {
            skip = 0;
            for (int j = M - 1; j >= 0; j--)
                if (getString()[j] != superstring[i]) {
                    skip = j - right[superstring[i]];
                    if (skip < 1) skip = 1;
                    break;
                }
            if (skip == 0) {
                return i;
            }
        }
        return N;
    }
}
