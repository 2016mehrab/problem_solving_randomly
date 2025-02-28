import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class LC873 {
    public int lenLongestFibSubseq(int[] arr) {
        int N = arr.length;
        // num, index
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int i = 0; i < N; ++i)
            map.put(arr[i], i);
        int[][] dp = new int[N][N];
        for (int i = N - 1; i > 0; --i) {
            for (int j = i - 1; j > -1; --j) {
                int prev = arr[j];
                int curr = arr[i];
                int nxt = prev + curr;
                int len = 2;
                if (map.containsKey(nxt) && map.get(nxt) > i) {
                    len = 1 + dp[i][map.get(nxt)];
                    maxLen = Math.max(len, maxLen);
                }
                dp[j][i] = len;

            }

        }
        System.out.println(maxLen);

        return maxLen;
    }

    public static void main(String[] args) {
        LC873 solution = new LC873();
        solution.lenLongestFibSubseq(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });
        solution.lenLongestFibSubseq(new int[] { 1, 3, 7, 11, 12, 14, 18 });
        solution.lenLongestFibSubseq(new int[] { 2, 4, 7, 8, 9, 10, 14, 15, 18, 23,
                32, 50 });
        solution.lenLongestFibSubseq(new int[] { 1, 3, 7, 8, 15 });
        solution.lenLongestFibSubseq(new int[] { 1, 3, 5 });
        solution.lenLongestFibSubseq(new int[] { 1, 3, 4, 5 });

    }
}
