class LC2016 {
    public int maximumDifference(int[] nums) {
        int N = nums.length;
        int minSoFar = nums[0];
        int maxDiff = -1;
        for (int i = 1; i < N; ++i) {
            if (nums[i] > minSoFar)
                maxDiff = Math.max(maxDiff, nums[i] - minSoFar);
            else
                minSoFar = nums[i];
        }
        return maxDiff;

    }

    public static void main(String[] args) {
        LC2016 solution = new LC2016();

    }
}
