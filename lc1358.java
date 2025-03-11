import java.util.HashMap;
import java.util.Map;

class LC1358 {

    public int numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int l = 0;
        for (int r = 0; r < s.length(); ++r) {
            char ch = s.charAt(r);
            map.putIfAbsent(ch, 0);
            map.put(ch, map.get(ch) + 1);
            while (r - l + 1 >= 3 && map.size() == 3) {
                res += s.length() - r;
                char preCh = s.charAt(l);
                map.put(preCh, map.get(preCh) - 1);
                if (map.get(preCh) == 0)
                    map.remove(preCh);
                ++l;
            }
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        LC1358 solution = new LC1358();
        solution.numberOfSubstrings("abcabc");
        solution.numberOfSubstrings("abc");
        solution.numberOfSubstrings("aaacb");

    }
}
