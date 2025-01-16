class LC2425 {

    public int xorAllNums(int[] nums1, int[] nums2) {
        int N1 = nums1.length;
        int N2 = nums2.length;
        int[][] map = new int[N1 + N2][2];
        int i = 0;
        for (i = 0; i < N1; ++i) {
            map[i] = new int[] { nums1[i], N2 };
        }
        ;
        for (int k = 0; k < N2; ++k) {
            map[i++] = new int[] { nums2[k], N1 };
        }
        int r = 0;
        for (int j = 0; j < N1 + N2; ++j) {
            if (map[j][1] % 2 != 0)
                r ^= map[j][0];

        }

        // check parity

        return r;
    }

    public static void main(String[] args) {
        LC2425 solution = new LC2425();
        int[] n1 = { 2, 1, 3 };
        int[] n2 = { 10, 2, 5, 0 };
        solution.xorAllNums(n1, n2);

    }
}
