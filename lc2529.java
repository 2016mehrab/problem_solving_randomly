class LC2529 {
    private int lowerBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int res = -1;
        while (l <= r) {

            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                res = mid;
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        return res;
    }

    private int upperBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int res = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                res = mid;
                l = mid + 1;
            }
        }
        return res;
    }

    public int maximumCount(int[] nums) {
        int positiveNumStartIndex = lowerBound(nums, 1);
        int negativeNumEndIndex = upperBound(nums, 0);
        if (positiveNumStartIndex == -1 && negativeNumEndIndex == -1)
            return 0;
        if (positiveNumStartIndex == -1)
            return negativeNumEndIndex + 1;
        if (negativeNumEndIndex == -1)
            return nums.length - positiveNumStartIndex;

        return Math.max((negativeNumEndIndex + 1), (nums.length - positiveNumStartIndex));
    }

    public static void main(String[] args) {
        LC2529 solution = new LC2529();
        System.out.println(solution.maximumCount(new int[] { 0, 0, 0, 0 }));

    }
}
