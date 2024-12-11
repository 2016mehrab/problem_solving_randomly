import java.util.Arrays;

class LC2779 {

    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int result = -1;
        for (int r = 0; r < nums.length; ++r) {
            while (nums[r] - nums[l] > 2 * k) {
                ++l;
            }
            result = result > (r - l + 1) ? result : (r - l + 1);
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        LC2779 solution = new LC2779();
        int[] n1 = { 4, 6, 1, 2 };
        int[] n2 = { 1, 1, 1, 1 };
        int[] n3 = { 5, 57, 46 };
        solution.maximumBeauty(n1, 2);
        solution.maximumBeauty(n2, 10);
        solution.maximumBeauty(n3, 15);
    }
}
