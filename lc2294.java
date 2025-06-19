import java.util.Arrays;

class LC2294 {
    public int partitionArray(int[] nums, int k) {
        int cnt = 1;
        Arrays.sort(nums);
        int min = nums[0];
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] - min <= k)
                continue;
            // not
            min = nums[i];
            ++cnt;
        }
        return cnt;

    }

    public static void main(String[] args) {
        LC2294 solution = new LC2294();
        solution.partitionArray(new int[] { 3, 1, 3, 4, 2 }, 0);

    }
}
