import java.util.Arrays;

class LC647 {

    private int isPalindrome(int f, int l, String s, int[][] cache) {
        while (f < l) {
            if (s.charAt(f) == s.charAt(l)) {
                ++f;
                --l;
            } else {
                cache[f][l] = 0;
                return 0;
            }

        }
        cache[f][l] = 1;
        return 1;

    }

    public int countSubstrings(String s) {
        int c = 0;
        int N = s.length();
        int[][] cache = new int[N][N];
        for (int[] i : cache)
            Arrays.fill(i, -1);

        for (int i = 0; i < N; ++i) {
            for (int j = i; j < N; ++j) {
                if (cache[i][j] == -1) {
                    cache[i][j] = isPalindrome(i, j, s, cache);
                    if (cache[i][j] == 1)
                        ++c;
                } else {
                    if (cache[i][j] == 1)
                        ++c;
                }

            }
        }

        System.out.println(c);
        return c;
    }

    public int countSubstringsOpt(String s) {
        int c = 0;

        int N = s.length();
        for (int i = 0; i < N; ++i) {
            int l = i, r = i;
            // count odd length substring
            while (l >= 0 && r < N && s.charAt(l) == s.charAt(r)) {
                ++c;
                --l;
                ++r;
            }
            // count even length substring
            l = i;
            r = i + 1;
            while (l >= 0 && r < N && s.charAt(l) == s.charAt(r)) {
                ++c;
                --l;
                ++r;
            }
        }

        System.out.println(c);
        return c;
    }

    public static void main(String[] args) {
        LC647 solution = new LC647();
        solution.countSubstrings("abc");
        solution.countSubstrings("aaa");
        solution.countSubstrings("aaaa");

    }
}
