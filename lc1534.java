class LC1534 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int N = arr.length;
        int cnt = 0;
        for (int i = 0; i <= N - 3; ++i) {
            for (int j = i + 1; j < N - 1; ++j) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < N; ++k) {
                        if ((Math.abs(arr[j] - arr[k]) <= b) && (Math.abs(arr[k] - arr[i]) <= c))
                            ++cnt;

                    }

                }
            }
        }
        return cnt;

    }

    public static void main(String[] args) {
        LC1534 solution = new LC1534();

    }
}
