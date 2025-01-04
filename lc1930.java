import java.util.HashSet;
import java.util.Set;

class LC1930 {
    private int getLastValidIdx(int index, String s) {
        for (int i = s.length() - 1; i > index; --i) {
            if (s.charAt(index) == s.charAt(i) && i - index + 1 >= 3)
                return i;
        }
        return -1;
    }

    public int countPalindromicSubsequence(String s) {
        Set<Character>[] CharSet = (Set<Character>[]) new HashSet[26];
        for (int i = 0; i < 26; ++i)
            CharSet[i] = new HashSet<>();
        int r = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (CharSet[s.charAt(i) - 'a'].size() != 0)
                continue;
            int compIdx = getLastValidIdx(i, s);
            if (compIdx == -1)
                continue;
            for (int j = i + 1; j < compIdx; ++j) {
                int currChar = s.charAt(i) - 'a';
                CharSet[currChar].add(s.charAt(j));
            }
        }
        for (int i = 0; i < 26; ++i)
            r += CharSet[i].size();

        System.out.println(r);
        return r;
    }

    public static void main(String[] args) {
        LC1930 solution = new LC1930();
        solution.countPalindromicSubsequence("aabca");
        solution.countPalindromicSubsequence("adc");
        solution.countPalindromicSubsequence("bbcbaba");

    }
}
