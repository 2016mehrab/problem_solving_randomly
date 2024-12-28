import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LC689 {
 public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] subarraySum = new int[nums.length - k + 1];
        int l = 0;
        int windowSum = 0;
        int idx = 0;

        for (int r = 0; r < nums.length; ++r) {
            windowSum += nums[r];
            if (r - l + 1 > k) {
                windowSum -= nums[l++];
            }
            if (r - l + 1 == k) {
                subarraySum[idx++] = windowSum;
            }
        }
        int[][] memo = new int[subarraySum.length][4];
        for (int[] row : memo) Arrays.fill(row, -1);

        List<Integer> res = new ArrayList<>();
        solve(0, 3, k, nums, subarraySum, res, memo);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private int helper(int idx, int cnt, int k, int[] sumArray, int[][] memo) {
        if (cnt == 0) return 0;
        if (idx >= sumArray.length) return Integer.MIN_VALUE;

        if (memo[idx][cnt] != -1) return memo[idx][cnt];

        int take = sumArray[idx] + helper(idx + k, cnt - 1, k, sumArray, memo);
        int skip = helper(idx + 1, cnt, k, sumArray, memo);

        memo[idx][cnt] = Math.max(take, skip);
        return memo[idx][cnt];
    }

    private void solve(int idx, int cnt, int k, int[] nums, int[] sumArray, List<Integer> res, int[][] memo) {
        if (cnt == 0) return;
        if (idx >= sumArray.length) return;

        int take = sumArray[idx] + helper(idx + k, cnt - 1, k, sumArray, memo);
        int skip = helper(idx + 1, cnt, k, sumArray, memo);

        if (take >= skip) {
            res.add(idx);
            solve(idx + k, cnt - 1, k, nums, sumArray, res, memo);
        } else {
            solve(idx + 1, cnt, k, nums, sumArray, res, memo);
        }
    }
    public static void main(String[] args) {
        LC689 solution = new LC689();
        int[]n1 = { 1,2,1,2,6,7,5,1 };
        int[]n2 = { 1,2,1,2,1,2,1,2,1 };
         solution.maxSumOfThreeSubarrays(n1 ,2);
         solution.maxSumOfThreeSubarrays(n2 ,2);
        
    }
}
