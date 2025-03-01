class LC2460 {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int swapIndex = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i] == nums[i - 1]) {
                nums[i - 1] *= 2;
                nums[i] = 0;
            }
        }

        for (int i = 0; i < n; ++i) {
            if (nums[swapIndex] != 0) {
                ++swapIndex;
                continue;
            }
            if (nums[swapIndex] == 0 && nums[i] != 0) {
                nums[swapIndex] = nums[i];
                nums[i] = 0;
                ++swapIndex;
            }
        }
        for (var x : nums)
            System.out.print(x + ", ");
        System.out.println();
        return nums;
    }

    public static void main(String[] args) {
        LC2460 solution = new LC2460();
        solution.applyOperations(new int[] { 1, 2, 2, 1, 1, 0 });
        solution.applyOperations(new int[] { 0, 1 });
        solution.applyOperations(new int[] { 2, 2, 4 });

    }
}
