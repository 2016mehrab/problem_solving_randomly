class LC2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] r = new int[nums.length];
        int less = 0, pv = 0, bg = 0, idx = 0;

        for (int i : nums) {
            if (i < pivot)
                ++less;
            else if (i > pivot)
                ++bg;
            else
                ++pv;
        }
        for (int i = 0; i < nums.length && less > 0; ++i) {
            if (nums[i] < pivot) {
                r[idx++] = nums[i];
                --less;
            }

        }
        for (int i = 0; i < nums.length && pv > 0; ++i) {
            if (nums[i] == pivot) {
                r[idx++] = nums[i];
                --pv;
            }

        }
        for (int i = 0; i < nums.length && bg > 0; ++i) {
            if (nums[i] > pivot) {
                r[idx++] = nums[i];
                --bg;
            }

        }
        return r;
    }

    public static void main(String[] args) {
        LC2161 solution = new LC2161();
        solution.pivotArray(new int[] { 9, 12, 5, 10, 14, 3, 10 }, 10);
        solution.pivotArray(new int[] { -3, 4, 3, 2 }, 2);

    }
}
