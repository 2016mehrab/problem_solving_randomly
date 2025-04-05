import java.util.HashMap;
import java.util.Map;

class LC1863 {
    private int subsetXORSumImpl(int idx, int[] nums, int total) {
        if (idx >= nums.length)
            return total;
        int take = subsetXORSumImpl(idx + 1, nums, total ^ nums[idx]);
        int skip = subsetXORSumImpl(idx + 1, nums, total);

        return take + skip;

    }

    public int subsetXORSum(int[] nums) {
        Map<String, Integer> dp = new HashMap<>();
        int s = subsetXORSumImpl(0, nums, 0);
        System.out.println(s);
        return s;
    }

    public static void main(String[] args) {
        LC1863 solution = new LC1863();
        solution.subsetXORSum(new int[] { 1, 3 });
        solution.subsetXORSum(new int[] { 5, 1, 6 });

    }
}
