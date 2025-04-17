import java.util.ArrayList;
import java.util.List;

class LC2176 {
    public int countPairs(int[] nums, int k) {

        int cnt = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] == nums[j]) {
                    cnt += (i * j) % k == 0 ? 1 : 0;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        LC2176 solution = new LC2176();
        solution.countPairs(new int[] { 10, 2, 3, 4, 9, 6, 3, 10, 3, 6, 3, 9, 1 }, 4);
        solution.countPairs(new int[] { 3, 1, 2, 2, 2, 1, 3 }, 2);
        solution.countPairs(new int[] { 1, 2, 3, 4 }, 1);

    }
}
