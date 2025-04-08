import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class LC3396 {
    // run operation till the last seen duplicate index
    public int minimumOperations(int[] nums) {

        Set<Integer> seen = new HashSet<>();
        int r = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            if (seen.contains(nums[i])) {
                r = (int) Math.ceil((i + 1) / 3.0);
                System.out.println(r);
                return r;
            } else {
                seen.add(nums[i]);
            }

        }
        System.out.println(r);
        return r;
    }

    public int minimumOperationsSim(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (var i : nums) {
            count.putIfAbsent(i, 0);
            count.put(i, count.get(i) + 1);
        }
        Set<Integer> keysToRemove = new HashSet<>();
        for (var entry : count.entrySet()) {
            if (entry.getValue() < 2) {
                keysToRemove.add(entry.getKey());
            }
        }
        count.keySet().removeAll(keysToRemove);
        int r = 0;
        while (nums.length > 0 && !count.isEmpty()) {
            nums = removeOp(nums, count);
            ++r;
        }
        System.out.println(r);
        return r;
    }

    private int[] removeOp(int[] nums, Map<Integer, Integer> count) {
        if (nums.length < 3) {
            count.clear();
            return new int[0];
        }
        for (int i = 0; i < 3; ++i) {
            if (count.containsKey(nums[i])) {
                count.put(nums[i], count.get(nums[i]) - 1);
                if (count.get(nums[i]) < 2)
                    count.remove(nums[i]);
            }
        }
        int[] newNum = new int[nums.length - 3];
        int j = 0;
        for (int i = 3; i < nums.length; ++i) {
            newNum[j++] = nums[i];
        }
        return newNum;
    }

    public static void main(String[] args) {
        LC3396 solution = new LC3396();
        solution.minimumOperations(new int[] { 1, 2, 3, 4, 2, 3, 3, 5, 7 });
        solution.minimumOperations(new int[] { 4, 5, 6, 4, 4 });

    }
}
