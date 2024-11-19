import java.util.HashMap;
import java.util.Map;

class LC2461 {
    // always have to do the sum but whether we count it or not that  depends on the map.
    public long maximumSubarraySum(int[] nums, int k) {
        int N = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        long result = 0;
        long sum = 0;
        int left = 0;

        for (int right = 0; right < N; ++right) {
            sum += nums[right];
            if (!map.containsKey(nums[right])) {
                map.put(nums[right], 0);
            }
            map.put(nums[right], map.get(nums[right]) + 1);

            if (right - left + 1 > k) {
                map.put(nums[left], map.get(nums[left])-1);
                if(map.get(nums[left])<1){
                    map.remove(nums[left]);
                }
                sum-= nums[left];
                ++left;
            }

            if (map.size() == k && right - left + 1 == k) {
                result = Math.max(result, sum);
            }

        }
        System.out.println(result);
        return result;

    }

    public static void main(String[] args) {
        LC2461 s = new LC2461();
        int[] n1 = { 1, 5, 4, 2, 9, 9, 9 };
        int[] n2 = { 4, 4, 4 };
        int[] n3 = { 4, 4, 4, 2 };
        int[] n4 = { 3, 3, 4, 2 };
        int[] n5 = { 1, 1, 1, 7, 8, 9 };
        // s.maximumSubarraySum(n1, 3);
        // s.maximumSubarraySum(n2, 3);
        // s.maximumSubarraySum(n3, 2);
        // s.maximumSubarraySum(n4, 2);
        s.maximumSubarraySum(n5, 3);

    }
}