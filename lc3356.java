class LC3356 {
    private void fillArray(int[] nums, int start, int end, int val) {
        nums[start] += val;
        if (end + 1 < nums.length)
            nums[end + 1] -= val;
    }

    private boolean createDifferenceArray(int[] nums, int[][] queries, int end) {
        int[] diff = new int[nums.length];
        for (int i = 0; i <= end; ++i) {
            int start = queries[i][0];
            int finish = queries[i][1];
            int val = queries[i][2];
            fillArray(diff, start, finish, val);
        }
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            diff[i] += sum;
            if (diff[i] - nums[i] < 0)
                return false;
            sum = diff[i];
        }
        return true;

    }

    private boolean isZeroArray(int[] nums) {
        int zcount = 0;
        for (int x : nums) {
            if (x <= 0)
                ++zcount;
        }
        return zcount == nums.length;
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        int M = nums.length;
        int N = queries.length;
        int res = 0;
        if (isZeroArray(nums))
            return res;
        res = -1;
        int l = 0;
        int r = N - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (createDifferenceArray(nums, queries, mid)) {
                res = mid + 1;
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        LC3356 solution = new LC3356();
        solution.minZeroArray(new int[] { 2, 0, 2 }, new int[][] { { 0, 2, 1 }, { 0, 2, 1 }, { 1, 1, 3 } });

    }
}
