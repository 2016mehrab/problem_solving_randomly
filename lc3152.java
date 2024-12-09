import java.util.Arrays;
import java.util.stream.Stream;

class LC3152 {
    int N;

    private int[] statusPerIndex(int[] nums) {
        int[] validIndex = new int[N];
        int j = 0;
        for (int i = N - 1; i >= 0; --i) {
            if (i == N - 1 || nums[i] % 2 == nums[i + 1] % 2)
                j = i;
            validIndex[i] = j;
        }

        return validIndex;
    }

    public boolean[] isArraySpecialPrefixApproach(int[] nums, int[][] queries) {
        N = nums.length;
        int M = queries.length;
        int[] arr = statusPerIndex(nums);
        boolean[] r = new boolean[M];
        for (int i = 0; i < M; ++i) {
            if (arr[queries[i][0]] >= queries[i][1])
                r[i] = true;
            else
                r[i] = false;

        }
        Arrays.stream(arr).forEach(System.out::println);
        return r;
    }

    private boolean hasViolatingIndex(int upperbound, int lowerbound, int[] violatingIndex, int size) {
        int l = 0;
        int r = size - 1;
        int mid = -1;
        while (l <= r) {
            mid = (l + r) / 2;
            if (violatingIndex[mid] != -1 && violatingIndex[mid] <= upperbound && violatingIndex[mid] >= lowerbound) {
                return true;
            } else if (violatingIndex[mid] > upperbound)
                r = mid - 1;
            else if (violatingIndex[mid] < lowerbound)
                l = mid + 1;
        }
        return false;
    }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        N = nums.length;
        int M = queries.length;
        int[] violatingIndex = new int[N];
        int index = 0;
        boolean[] r = new boolean[M];

        Arrays.fill(violatingIndex, -1);
        for (int i = 0; i < N; ++i) {
            if (i < N - 1 && nums[i] % 2 == nums[i + 1] % 2)
                violatingIndex[index++] = i + 1;
        }

        for (int i = 0; i < M; ++i) {
            int start = queries[i][0];
            int end = queries[i][1];
            r[i] = !hasViolatingIndex(end, start + 1, violatingIndex, index);
        }
        for (boolean x : r)
            System.out.println(x);

        // Arrays.stream(violatingIndex).forEach(System.out::println);
        return r;
    }

    public static void main(String[] args) {
        LC3152 solution = new LC3152();
        int[] n1 = { 3, 4, 1, 2, 6 };
        int[][] q1 = { { 0, 4 } };

        int[] n2 = { 4, 3, 1, 6 };
        int[][] q2 = { { 0, 2 }, { 2, 3 } };
        solution.isArraySpecial(n1, q1);
        System.out.println();
        solution.isArraySpecial(n2, q2);

    }
}
