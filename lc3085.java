import java.util.HashMap;
import java.util.Map;

class LC3085 {
    public int minimumDeletions(String word, int k) {
        // can't add chars
        // so for freq lower than curr freq, we remove the char
        // which frequency should be target? that should give
        // us min nums chars to remove?
        // it should be from the freq of word
        // because we can't add characters
        int res = Integer.MAX_VALUE;
        Map<Character, Integer> cnt = new HashMap<>();
        for (var ch : word.toCharArray()) {
            cnt.put(ch, cnt.getOrDefault(ch, 0) + 1);
        }
        for (var a : cnt.values()) {
            int del = 0;
            for (var b : cnt.values()) {
                if (b > a + k) {
                    del += b - (a + k);
                } else if (a > b)
                    del += b;
            }
            res = Math.min(del, res);
        }

        return res;

    }

    public static void main(String[] args) {
        LC3085 solution = new LC3085();

    }
}
