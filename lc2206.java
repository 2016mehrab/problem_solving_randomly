import java.util.HashMap;
import java.util.Map;

class LC2206 {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.putIfAbsent(i, 0);
            count.put(i, count.get(i) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() % 2 != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        LC2206 solution = new LC2206();

    }
}
