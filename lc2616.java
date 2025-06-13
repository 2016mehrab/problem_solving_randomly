import java.util.Arrays;

class LC2616 {
    int[] isValid(int difference, int[] nums, int pairs) {
        int[] res = new int[2];
        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i += 1) {
            if (Math.abs(nums[i] - nums[i + 1]) == difference) {
                cnt++;
                // exact match
                res[1] = 1;
                i += 1;
            } else if (Math.abs(nums[i] - nums[i + 1]) < difference) {
                cnt++;
                i += 1;
            }
        }
        if (cnt >= pairs)
            res[0] = 1;
        return res;

    }

    public int minimizeMax(int[] nums, int p) {
        if (p == 0)
            return 0;
        int N = nums.length;
        Arrays.sort(nums);
        int diff = 1_000_000_001;
        int l = 0;
        int r = 0;
        for (int i = 0; i < N; ++i) {
            r = Math.max(r, nums[i]);
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            int[] tmp = isValid(mid, nums, p);

            if (tmp[0] == 1) {
                if (tmp[1] == 1)
                    diff = Math.min(diff, mid);
                r = mid - 1;
            } else
                l = mid + 1;
        }

        // empty set
        if (diff == 1_000_000_001)
            return 0;
        return diff;
    }

    public static void main(String[] args) {
        LC2616 solution = new LC2616();

    }
}
