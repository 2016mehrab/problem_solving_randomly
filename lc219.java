import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class LC219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        int right = 0;
        Set<Integer> set = new HashSet<>();
        while (right < nums.length) {
            if (right - left > k) {
                set.remove(nums[left]);
                ++left;
            }
            if (right != 0 && !set.isEmpty() && set.contains(nums[right])) {
                return true;
            }
            set.add(nums[right]);
            ++right;
        }
        return false;

    }

    public static void main(String[] args) {
        LC219 s = new LC219();
        int[] t = { 1, 2, 3, 1 };
        int[] t5 = { 1, 0, 1, 1 };
        int[] t2 = { 1, 2, 3, 1, 2, 3 };
        int[] t3 = { 1, 2, 1 };
        int[] t4 = { 0, 1, 2, 3, 2, 5 };
        System.out.println(s.containsNearbyDuplicate(t, 3));
        System.out.println(s.containsNearbyDuplicate(t5, 1));
        System.out.println(s.containsNearbyDuplicate(t2, 2));
        System.out.println(s.containsNearbyDuplicate(t3, 0));
        System.out.println(s.containsNearbyDuplicate(t4, 3));
        System.out.println(s.containsNearbyDuplicate(t4, 5));
        ;

    }

}
