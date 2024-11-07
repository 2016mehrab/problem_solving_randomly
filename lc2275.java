class LC2275 {
    public int solve(int[] arr, int index, int totalBitwiseAnd) {
        if (index >= arr.length) {
            return 0;
        }
        int take = -1;
        if ((totalBitwiseAnd & arr[index]) != 0) {
            take = 1 + solve(arr, index + 1, totalBitwiseAnd & arr[index]);
        }
        int skip = solve(arr, index + 1, totalBitwiseAnd);
        return Math.max(take, skip);
    }

    public int largestCombinationDP(int[] candidates) {
        return solve(candidates, 0, -1);
    }

    public int largestCombination(int[] candidates) {
        int max = -1;
        for (int i : candidates) {
            max = max < i ? i : max;
        }
        max = Integer.toBinaryString(max).length();
        int[] posarr = new int[max];
        for (int i : candidates) {
            for (int position = 0; position < max; ++position) {
                if ((i & (1 << position)) != 0) {
                    posarr[position] += 1;
                }
            }
        }
        max=-1;
        for (int i : posarr) {
            max = max < i ? i : max;
        }
        return max;
    }

    public static void main(String args[]) {
        // int[] arr = { 16, 17, 71, 62, 12, 24, 14 };
        int[] arr = {8,8};
        LC2275 s = new LC2275();
        System.out.println(s.largestCombination(arr));
    }
}
