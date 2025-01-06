class LC1769 {
    public int[] minOperations(String boxes) {
        int N = boxes.length();
        int[] r = new int[N];
        int balls = 0;
        int moves = 0;
        for (int i = 0; i < N; ++i) {
            moves = balls * 1 + moves;
            r[i] = moves;
            if (boxes.charAt(i) == '1')
                ++balls;
        }

        balls = 0;
        moves = 0;

        for (int i = N - 1; i > -1; --i) {
            moves = balls * 1 + moves;
            r[i] += moves;
            if (boxes.charAt(i) == '1')
                ++balls;
        }

        for (int i : r)
            System.out.println(i);
        return r;

    }

    public static void main(String[] args) {
        LC1769 solution = new LC1769();
        solution.minOperations("110");
        solution.minOperations("001011");

    }
}
