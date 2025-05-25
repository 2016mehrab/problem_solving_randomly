import java.util.HashMap;
import java.util.Map;

class LC2131 {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> word_freq = new HashMap<>();
        int res = 0;
        for (var word : words) {
            String reversed = new StringBuilder(word).reverse().toString();
            if (word_freq.getOrDefault(reversed, 0) > 0) {
                res += 4;
                word_freq.put(reversed, word_freq.get(reversed) - 1);
            } else
                word_freq.put(word, word_freq.getOrDefault(word, 0) + 1);
        }
        for (var x : word_freq.entrySet()) {
            // add the same char string of odd freq one to the center
            var word = x.getKey();
            if (word.charAt(0) == word.charAt(1) && x.getValue() > 0) {
                res += 2;
                break;

            }
        }
        return res;

    }

    public static void main(String[] args) {
        LC2131 solution = new LC2131();

    }
}
