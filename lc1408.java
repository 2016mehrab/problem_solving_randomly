import java.util.ArrayList;
import java.util.List;

class LC1408 {
    private boolean isSubString(int curr, int strTocmp, String[] words) {
        return words[curr].indexOf(words[strTocmp]) != -1;

    }

    public List<String> stringMatching(String[] words) {
        List<String> r = new ArrayList<>();
        for (int curr = 0; curr < words.length; ++curr) {
            for (int cmp = 0; cmp < words.length; ++cmp) {
                if (curr == cmp)
                    continue;
                if (isSubString(curr, cmp, words)) {
                    r.add(words[curr]);
                    break;
                }

            }
        }
        return r;

    }

    public static void main(String[] args) {
        LC1408 solution = new LC1408();

    }
}
