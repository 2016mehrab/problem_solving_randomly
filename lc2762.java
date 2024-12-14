import java.util.ArrayDeque;
import java.util.Deque;

class LC2762 {
    public long continuousSubarrays(int[] nums) {
        int N = nums.length;
        Deque<Integer> maxQ = new ArrayDeque<>();
        Deque<Integer> minQ = new ArrayDeque<>();
        int l = 0;
        long cnt = 0;
        for (int r = 0; r < N; ++r) {
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] < nums[r]) {
                maxQ.pollLast();
            }
            maxQ.addLast(r);
            while (!minQ.isEmpty() && nums[minQ.peekLast()] > nums[r]) {
                minQ.pollLast();
            }
            minQ.addLast(r);
            while (!minQ.isEmpty() && !maxQ.isEmpty() && nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > 2) {
                if (maxQ.peekFirst() < minQ.peekFirst()) {
                    l = maxQ.peekFirst() + 1;
                    maxQ.pollFirst();
                } else {
                    l = minQ.peekFirst() + 1;
                    minQ.pollFirst();
                }
            }

            cnt += r - l + 1;

        }

        System.out.println("count -> " + cnt);
        return cnt;
    }

    public static void main(String[] args) {
        LC2762 solution = new LC2762();
        int[] n1 = { 5, 4, 2, 4 };
        int[] n2 = { 1, 2, 3 };
        int[] n3 = { 1, 4, 2, 3, 1 };
        solution.continuousSubarrays(n1);
        solution.continuousSubarrays(n2);
        solution.continuousSubarrays(n3);

    }
}
