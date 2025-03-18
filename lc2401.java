class LC2401 {
    public int longestNiceSubarray(int[] nums) {
        int res = -1;
        int l = 0;
        int mask = 0;
        for (int r = 0; r < nums.length; ++r) {
            if ((mask & nums[r]) == 0) {
                res = Math.max(res, r - l + 1);
            } else {
                while ((mask & nums[r]) != 0) {
                    mask ^= nums[l++];
                }
            }
            mask = mask | nums[r];
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        LC2401 solution = new LC2401();
        solution.longestNiceSubarray(new int[] { 1, 3, 8, 48, 10 });
        solution.longestNiceSubarray(new int[] { 3, 1, 5, 11, 13 });

    }
}
