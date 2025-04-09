import java.util.HashSet;
import java.util.Set;

class LC3375 {
    public int minOperations(int[] nums, int k) {
        int min = nums[0];
        Set<Integer> dist = new HashSet<>();
        boolean kInNums = false;
        for (var i : nums) {
            min = Math.min(i, min);
            dist.add(i);
            kInNums = kInNums || (i == k);
        }
        // an operation cannot increase the value
        if (k > min)
            return -1;
        // only distinct element matters as an operation equally reduces duplicate
        // elements
        return kInNums ? dist.size() - 1 : dist.size();
    }

    public static void main(String[] args) {
        LC3375 solution = new LC3375();

    }
}
