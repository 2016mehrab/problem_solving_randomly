import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class LC873 {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        // Store array elements in set for O(1) lookup
        Set<Integer> numSet = new HashSet<>();
        for (int num : arr) {
            numSet.add(num);
        }

        int maxLen = 0;
        // Try all possible first two numbers of sequence
        for (int start = 0; start < n; ++start) {
            for (int next = start + 1; next < n; ++next) {
                // Start with first two numbers
                int prev = arr[next];
                int curr = arr[start] + arr[next];
                int len = 2;

                // Keep finding next Fibonacci number
                while (numSet.contains(curr)) {
                    // Update values for next iteration
                    int temp = curr;
                    curr += prev;
                    prev = temp;
                    maxLen = Math.max(maxLen, ++len);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LC873 solution = new LC873();
        // solution.lenLongestFibSubseq(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });
        // solution.lenLongestFibSubseq(new int[] { 1, 3, 7, 11, 12, 14, 18 });
        // solution.lenLongestFibSubseq(new int[] { 2, 4, 7, 8, 9, 10, 14, 15, 18, 23,
        // 32, 50 });
        // solution.lenLongestFibSubseq(new int[] { 1, 3, 7, 8, 15 });
        solution.lenLongestFibSubseq(new int[] { 1, 3, 5 });
        solution.lenLongestFibSubseq(new int[] { 1, 3, 4, 5 });

    }
}
