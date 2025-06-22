class LC2138 {
    public String[] divideString(String s, int k, char fill) {
        int N = s.length();
        int size = N % k == 0 ? N / k : (N / k) + 1;
        int j = 0;
        String[] res = new String[size];
        for (int i = 0; i < N; ++i) {
            if (i % k == 0 && i != 0) {
                res[j++] = s.substring(i - k, i);
            }
        }
        if (N % k == 0) {
            res[j++] = s.substring(N - k, N);
            return res;
        }
        var rem = N % k;
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(N - rem, N));
        for (int i = 0; i < k - rem; ++i) {
            sb.append(fill);
        }
        res[j++] = sb.toString();
        return res;

    }

    public static void main(String[] args) {
        LC2138 solution = new LC2138();

    }
}
