import java.util.Arrays;

class LC5 {
    private boolean isPalindromeIterative(int idx1, int idx2, StringBuilder sb) {
        while (idx1 < idx2) {
            if (sb.charAt(idx1) == sb.charAt(idx2)) {
                ++idx1;
                --idx2;
                continue;
            } else
                return false;
        }
        return true;
    }

    private boolean isPalindrome(int idx1, int idx2, StringBuilder sb, byte[][] cache) {
        if (cache[idx1][idx2] != -1) {
            return cache[idx1][idx2] == 1;
        }
        if (idx1 >= idx2)
            return true;
        if (sb.charAt(idx1) == sb.charAt(idx2)) {
            if (isPalindrome(idx1 + 1, idx2 - 1, sb, cache)) {
                cache[idx1][idx2] = 1;
            } else
                cache[idx1][idx2] = 0;
            return cache[idx1][idx2] == 1;
        } else
            return false;
    }

    public String longestPalindrome(String s) {
        int maxlen = -1;
        int N = s.length();
        // -1 =not visited, 1= true, 0 =false;
        byte[][] cache = new byte[N][N];
        for (byte[] c : cache)
            Arrays.fill(c, (byte) -1);

        StringBuilder sb = new StringBuilder(s);
        String res = "";
        for (int i = 0; i < N; ++i) {
            for (int j = i; j < N; ++j) {
                if (isPalindrome(i, j, sb, cache)) {
                    if (j - i + 1 > maxlen) {
                        maxlen = j - i + 1;
                        res = sb.substring(i, j + 1).toString();
                    }
                }

            }
        }
        System.out.println(res);

        return res;
    }

    public static void main(String[] args) {
        LC5 solution = new LC5();
        solution.longestPalindrome("babad");
        solution.longestPalindrome("cbbd");
        solution.longestPalindrome("a");

    }
}
