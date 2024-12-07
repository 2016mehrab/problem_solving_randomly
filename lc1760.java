import java.util.Arrays;

class LC1760 {
    private boolean isPossible(int[] nums, int mid, int maxOps) {
        int ops = 0;
        for (int i : nums) {
            ops += i / mid;
            if (i % mid == 0) {
                --ops;
            }
        }
        return ops <= maxOps;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int minSize = -1;
        int l = 1;
        int r = Arrays.stream(nums).max().orElseThrow(() -> new RuntimeException("Array is empty"));
        int mid = -1;
        while (l < r) {
            mid = (l + r) / 2;
            if (isPossible(nums, mid, maxOperations)) {
                minSize = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        System.out.println(minSize);
        return minSize;
    }

    public static void main(String[] args) {
        LC1760 solution = new LC1760();
        int[] n1 = { 9 };
        int[] n2 = { 2, 4, 8, 2 };
        solution.minimumSize(n1, 2);
        solution.minimumSize(n2, 4);

    }
}
