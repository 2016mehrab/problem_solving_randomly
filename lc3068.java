class LC3068 {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long minimumBenefit = Integer.MAX_VALUE;
        long minimumloss = Integer.MAX_VALUE;
        // trees so every node is connected
        // goal: maximize nums elements
        // can do xor on any two nodes
        long ops = 0;
        long maxSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            long tmp = nums[i] ^ k;
            if (tmp > nums[i]) {
                // if obligated we would want to remove that benefits less
                minimumBenefit = Math.min(tmp - nums[i], minimumBenefit);
                maxSum += tmp;
                ++ops;
                continue;
            }
            // loss
            minimumloss = Math.min(minimumloss, nums[i] - tmp);
            // not gonna do xor where there's loss
            maxSum += nums[i];
        }
        // we have the highest achievable sum

        // but is the number of operation even?

        // how to make it even ? by removing or adding?
        if ((ops & 1) == 1) {
            // overall positive benefit so we can take the loss rather minimizing benefit
            if (minimumBenefit - minimumloss > 0) {
                return maxSum - minimumloss;
            }
            // remove the least benefit as it adds no overall value
            return maxSum - minimumBenefit;

        }
        return maxSum;
    }

    public static void main(String[] args) {
        LC3068 solution = new LC3068();
        System.out.println(solution.maximumValueSum(new int[] { 1, 2, 1 }, 3, new int[][] { { 0, 1 }, { 0, 2 } }));

    }
}
