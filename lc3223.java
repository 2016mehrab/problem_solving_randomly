class LC3223 {
    public int minimumLength(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            ++cnt[c - 'a'];
        }
        int r = 0;
        for (int i : cnt) {
            while (i >= 3) {

                i = i - 2 * (int) (i / 3);
            }
            r += i;
        }
        System.out.println(r);
        return r;

    }

    public static void main(String[] args) {
        LC3223 solution = new LC3223();
        solution.minimumLength("aaaaa");
        solution.minimumLength("abaacbcbb");
        solution.minimumLength("aa");

    }
}
