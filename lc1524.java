class LC1524 {
    private int MOD = 1000000000 + 7;

    private boolean isOdd(int n) {
        return n % 2 == 1;
    }

    public int numOfSubarrays(int[] arr) {
        int r = 0;
        int N = arr.length;
        int sum = 0;
        int odd_cnt = 0;
        int evn_cnt = 0;
        // if all even nums then 0;
        for (int i = 0; i < N; ++i) {
            sum += arr[i] % MOD;
            if (isOdd(sum)) {
                r += 1 + evn_cnt;
                ++odd_cnt;
                r %= MOD;
            } else {
                ++evn_cnt;
                r += odd_cnt;
                r %= MOD;
            }
        }
        System.out.println(r);
        return r;

    }

    public int numOfSubarraysBF(int[] arr) {
        int r = 0;
        int N = arr.length;
        // if all even nums then 0;
        for (int i = 0; i < N; ++i) {
            int sum = 0;
            for (int j = i; j < N; ++j) {
                sum += arr[j] % MOD;
                if (isOdd(sum)) {
                    ++r;
                    r %= MOD;
                }

            }
        }
        System.out.println(r);
        return r;

    }

    public static void main(String[] args) {
        LC1524 solution = new LC1524();
        solution.numOfSubarrays(new int[] { 1, 3, 5 });
        solution.numOfSubarrays(new int[] { 2, 4, 6 });
        solution.numOfSubarrays(new int[] { 1, 2, 3, 4, 5, 6, 7 });

    }
}
