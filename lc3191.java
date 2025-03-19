class LC3191 {
    private void updateArr(int[] flipArr, int idx) {
        int cnt = 0;
        for (int i = idx; i < flipArr.length && cnt < 3; ++i, ++cnt)
            flipArr[i] += 1;
    }

    public int minOperationsREV(int[] nums) {
        int flips = 0;
        int sum = 0;
        for (int i = 2; i < nums.length; ++i) {
            if (nums[i - 2] == 0) {
                ++flips;
                nums[i - 2] ^= 1;
                nums[i - 1] ^= 1;
                nums[i] ^= 1;
            }
        }
        for (int i : nums)
            sum += i;
        if (sum == nums.length)
            return flips;
        return -1;
    }

    public int minOperations(int[] nums) {
        int flips = 0;
        int sum = 0;
        for (int i = 0; i <= nums.length - 3; ++i) {
            if (nums[i] == 0) {
                ++flips;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                nums[i] ^= 1;
            }
        }
        for (int i : nums)
            sum += i;
        if (sum == nums.length)
            return flips;
        return -1;
    }

    public static void main(String[] args) {
        LC3191 solution = new LC3191();
        solution.minOperations(new int[] { 1, 0, 0, 0, 1 });
        solution.minOperations(new int[] { 0, 1, 1, 1, 0, 0 });
        solution.minOperations(new int[] { 0, 1, 1, 1 });

    }
}
