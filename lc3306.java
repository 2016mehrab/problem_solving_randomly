import java.util.HashMap;
import java.util.Map;

class LC3306 {
    private boolean isVowel(char ch) {

        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private long atLeastKConsonants(String word, int k) {
        long res = 0;
        Map<Character, Integer> vowelMap = new HashMap<>();
        int consonantCount = 0;
        int l = 0;
        for (int r = 0; r < word.length(); ++r) {
            char tmp = word.charAt(r);
            if (isVowel(tmp)) {
                vowelMap.putIfAbsent(tmp, 0);
                vowelMap.put(tmp, vowelMap.get(tmp) + 1);
            } else {
                ++consonantCount;
            }
            while (vowelMap.size() == 5 && consonantCount >= k) {
                res += word.length() - r;
                char tmp2 = word.charAt(l);
                if (isVowel(tmp2)) {
                    // dec vowel
                    vowelMap.put(tmp2, vowelMap.get(tmp2) - 1);
                    if (vowelMap.get(tmp2) == 0)
                        vowelMap.remove(tmp2);
                } else
                    --consonantCount;
                // dec consonant
                ++l;
            }
        }
        return res;

    }

    public long countOfSubstrings(String word, int k) {
        return this.atLeastKConsonants(word, k) - this.atLeastKConsonants(word, k + 1);

    }

    public static void main(String[] args) {

        LC3306 solution = new LC3306();
        solution.countOfSubstrings("aeioqq", 1);
        solution.countOfSubstrings("aeiou", 0);
        solution.countOfSubstrings("ieaouqqieaouqq", 1);
        solution.countOfSubstrings("iqeaouqi", 2);

    }
}
