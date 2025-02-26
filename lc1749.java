class LC1749 {
    public int maxAbsoluteSum(int[] nums) {
        int N = nums.length;
        int[] prefixSum = new int[N];
        int s = 0;
        int k = 0;
        int r = 0;
        // max
        for (int i : nums) {
            s += i;
            // prefixSum[k++] = s<0 ? 0 : s;
            s = s < 0 ? 0 : s;
            r = Math.max(r, Math.abs(s));
        }
        // min
        s = 0;
        for (int i : nums) {
            s += i;
            s = s > 0 ? 0 : s;
            // prefixSum[k++] = s>0 ? 0 : s;
            r = Math.max(r, Math.abs(s));
        }

        System.out.println(r);
        return r;

    }

    public static void main(String[] args) {
        LC1749 solution = new LC1749();
        solution.maxAbsoluteSum(new int[] { 1, -3, 2, 3, -4 });
        solution.maxAbsoluteSum(new int[] { 2, -5, 1, -4, 3, -2 });
        solution.maxAbsoluteSum(new int[] { 1 });
        solution.maxAbsoluteSum(new int[] {});

    }
}
