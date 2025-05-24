import java.util.ArrayList;
import java.util.List;

class LC2942 {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            if (word.chars().anyMatch(ch -> x == ch))
                res.add(i);
        }
        return res;

    }

    public static void main(String[] args) {
        LC2942 solution = new LC2942();

    }
}
