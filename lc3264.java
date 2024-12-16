import java.util.PriorityQueue;

class LC3264 {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> minheap = new PriorityQueue<>((f, l) -> {
            if (f[0] == l[0]) {
                return f[1] - l[1];
            }
            return f[0] - l[0];
        });
        for (int i = 0; i < nums.length; ++i) {
            minheap.add(new int[] { nums[i], i });
        }
        for (int i = 0; i < k; ++i) {
            int[] curr = minheap.poll();
            int idx = curr[1];
            int val = curr[0] * multiplier;
            nums[idx] = val;
            minheap.add(new int[] { val, idx });
        }

        return nums;
    }

    public static void main(String[] args) {
        LC3264 solution = new LC3264();
        int[] n1 = { 2, 1, 3, 5, 6 };
        int[] n2 = { 1, 2 };
        solution.getFinalState(n1, 5, 2);
        solution.getFinalState(n2, 3, 4);

    }
}
