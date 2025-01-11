class LC1400 {
    public boolean canConstruct(String s, int k) {
        if (s.length() == k)
            return true;
        if (s.length() < k)
            return false;
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            ++map[c - 'a'];
        }
        int oddCnt = 0;
        for (int i = 0; i < 26; ++i) {
            if (map[i] % 2 != 0)
                ++oddCnt;
        }
        if (oddCnt > k)
            return false;
        return true;
    }

    public static void main(String[] args) {
        LC1400 solution = new LC1400();
        boolean[] t = new boolean[3];
        int i = 0;
        t[i++] = solution.canConstruct("annabelle", 2);
        t[i++] = solution.canConstruct("leetcode", 3);
        t[i++] = solution.canConstruct("true", 4);
        // for (boolean x : t)
        //     System.out.println(x);

    }
}
