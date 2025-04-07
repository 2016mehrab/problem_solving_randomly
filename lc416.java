import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class LC416 {
    private boolean solve(int[] nums, int idx, int remainingSum, short[][] dp) {
        if (remainingSum == 0)
            return true;
        if (idx >= nums.length)
            return false;
        if (dp[idx][remainingSum] != -1) {
            if (dp[idx][remainingSum] == 1)
                return true;
            return false;
        }
        boolean take = false;
        if (nums[idx] <= remainingSum) {
            take = solve(nums, idx + 1, remainingSum - nums[idx], dp);
        }
        boolean skip = solve(nums, idx + 1, remainingSum, dp);
        if (skip || take) {
            dp[idx][remainingSum] = 1;
        } else {
            dp[idx][remainingSum] = 0;

        }

        return skip || take;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (var x : nums)
            sum += x;
        if (sum % 2 != 0)
            return false;
        short[][] dp = new short[nums.length][20001];
        for (var d : dp)
            Arrays.fill(d, (short) -1);

        return solve(nums, 0, sum / 2, dp);
    }

    public static void main(String[] args) {
        LC416 solution = new LC416();

    }
}
