/*
 *Given an integer array numsnums and an integer targettarget, return the number of 
 valid combinations of indices (i,j)(i,j) such that:

    0≤i<j<n0≤i<j<n (where nn is the length of numsnums), meaning ii is strictly less than jj.
    The product of the elements at indices ii and jj, i.e., 
    nums[i]⋅nums[j], equals target.
 * */

import java.util.HashMap;
import java.util.Map;

class CountValidIndexCombinations {
    static int solution(int[] nums, int target) {
        Map<Integer, Integer> num_cnt = new HashMap<>();
        int pairs = 0;
        for (int i = 0; i < nums.length; ++i) {
            var curr = nums[i];
            if (target % curr == 0)
                pairs += num_cnt.containsKey(target / curr) ? num_cnt.get(target / curr) : 0;
            num_cnt.putIfAbsent(curr, 0);
            num_cnt.put(curr, num_cnt.get(curr) + 1);

        }

        System.out.println(pairs);
        return pairs;

    }

    public static void main(String[] args) {
        solution(new int[] { 2, 3, 4, 6, 2 }, 12);
        solution(new int[] { 2, 3, 3, 4, 6, 2 }, 12);
        solution(new int[] { 1, 5, 5, 5 }, 25);
        solution(new int[] { 2, 3, 4 }, 10);
        solution(new int[] { -2, -6, 3, -4 }, 12);

    }

}
