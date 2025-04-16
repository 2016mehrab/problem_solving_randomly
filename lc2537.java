import java.util.HashMap;
import java.util.Map;

class LC2537 {
    public long countGood(int[] nums, int k) {

        long sub_cnt = 0;
        int pairs = 0;
        int i = 0;
        int N = nums.length;

        Map<Integer, Integer> num_cnt = new HashMap<>();

        for (int j = 0; j < N; ++j) {
            var val = nums[j];
            pairs += num_cnt.getOrDefault(val, 0);
            num_cnt.putIfAbsent(val, 0);
            num_cnt.put(val, num_cnt.get(val) + 1);

            while (pairs >= k && i < N) {
                sub_cnt += N - j;
                var removed_num = nums[i];

                num_cnt.put(removed_num, num_cnt.get(removed_num) - 1);
                pairs -= num_cnt.get(removed_num);

                ++i;

            }
            // only adds meaningful pair when the current num was seen before

        }
        System.out.println(sub_cnt);
        return sub_cnt;
    }

    public static void main(String[] args) {
        LC2537 solution = new LC2537();
        solution.countGood(new int[] { 1, 1, 1 }, 2);
        solution.countGood(new int[] { 1, 1, 1, 1, 1 }, 10);
        solution.countGood(new int[] { 3, 1, 4, 3, 2, 2, 4 }, 2);

    }
}
