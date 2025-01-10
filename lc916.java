import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LC916 {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> r = new ArrayList<>();
        int[] words2Map = new int[26];
        Arrays.fill(words2Map, -1);

        for (String w : words2) {
            int[] tmpMap = new int[26];
            for (char c : w.toCharArray()) {
                int idx = c - 'a';
                ++tmpMap[idx];
                words2Map[idx] = Math.max(words2Map[idx], tmpMap[idx]);
            }
        }

        for (String w : words1) {

            int[] tmpMap = new int[26];

            // get the map of current word
            for (char c : w.toCharArray()) {
                int idx = c - 'a';
                ++tmpMap[idx];
            }

            r.add(w);

            // check if it is a subset of word2
            for (int i = 0; i < 26; ++i) {
                if (words2Map[i] != -1 && tmpMap[i] < words2Map[i]) {
                    r.remove(r.size() - 1);
                    break;
                }
            }
        }
        System.out.println(r);
        return r;
    }

    public static void main(String[] args) {
        LC916 solution = new LC916();
        String[] w1 = { "amazon", "apple", "facebook", "google", "leetcode" };
        String[] w2 = { "e", "o" };
        solution.wordSubsets(w1, w2);

    }
}
