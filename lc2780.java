import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LC2780 {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> right_cnt = new HashMap<>();
        Map<Integer, Integer> left_cnt = new HashMap<>();
        for (var x : nums) {
            right_cnt.putIfAbsent(x, 0);
            right_cnt.put(x, right_cnt.get(x) + 1);
        }
        for (int i = 0; i < nums.size(); ++i) {
            var num = nums.get(i);
            left_cnt.putIfAbsent(num, 0);
            left_cnt.put(num, left_cnt.get(num) + 1);
            right_cnt.put(num, right_cnt.get(num) - 1);
            int left_size = i + 1;
            int right_size = nums.size() - left_size;
            if (left_cnt.get(num) > left_size / 2 && right_cnt.get(num) > right_size / 2)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        LC2780 solution = new LC2780();

    }
}
