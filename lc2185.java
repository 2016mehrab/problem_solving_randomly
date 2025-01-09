class LC2185 {
    public int prefixCount(String[] words, String pref) {
        int N = words.length;
        int r = 0;
        for (int i = 0; i < N; ++i) {
            if (words[i].startsWith(pref))
                ++r;
        }
        return r;
    }

    public static void main(String[] args) {
        LC2185 solution = new LC2185();

    }
}
