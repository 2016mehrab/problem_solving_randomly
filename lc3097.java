class LC3097 {
    public int minimumSubarrayLength(int[] nums, int k) {
        int first = 0;
        int second = 0;
        // setbits arr
        int r = Integer.MAX_VALUE;
        int[] setbits = new int[32];
        while (second < nums.length) {
            addInWindow(nums[second], setbits);
            while (first <= second && getDecimal(setbits) >= k) {
                r = Math.min(r, second - first + 1);
                removeFromWindow(nums[first], setbits);
                ++first;
            }
            ++second;
        }
        System.out.println(r);
        return r == Integer.MAX_VALUE ? -1 : r;
    }

    static int getDecimal(int[] setArr) {
        int r = 0;
        for (int i = 0; i < 32; ++i) {
            if (setArr[i] > 0) {

                r += (1 << i);
            }
        }
        return r;

    }

    static void removeFromWindow(int n, int[] setArr) {
        for (int i = 0; i < 32; ++i) {
            if (((n >> i) & 1) != 0) {
                setArr[i] -= 1;
            }
        }

    }

    static void addInWindow(int n, int[] setArr) {
        for (int i = 0; i < 32; ++i) {
            if (((n >> i) & 1) != 0) {
                setArr[i] += 1;
            }
        }

    }

    public static void main(String[] args) {
        LC3097 s = new LC3097();
        int []a= {2,1,8};
        s.minimumSubarrayLength(a, 10);

    }
}