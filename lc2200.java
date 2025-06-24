import java.util.*;

class LC2200 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> res = new HashSet<>();
        List<Integer> keyIdx = new ArrayList<>();

        // find all keys
        for (int i = 0; i < nums.length; ++i) {
            if (key == nums[i]) {
                keyIdx.add(i);
            }
        }
        for (var idx : keyIdx) {
            for (int i = 0; i < nums.length; ++i) {
                if (Math.abs(i - idx) <= k) {
                    res.add(i);
                }
            }

        }
        List<Integer> r = new ArrayList<Integer>(res);
        Collections.sort(r);
        return r;

    }

    public static void main(String[] args) {
        LC2200 solution = new LC2200();

    }
}
