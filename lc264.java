class LC264 {
    public int nthUglyNumber(int n) {
        int[] uglyArr = new int[n + 1];
        int i2, i3, i5;
        i2 = i3 = i5 = 1;
        uglyArr[1] = 1;
        for (int i = 2; i <= n; ++i) {
            int i2UglyNum = uglyArr[i2] * 2;
            int i3UglyNum = uglyArr[i3] * 3;
            int i5UglyNum = uglyArr[i5] * 5;
            int nextUglyNum = Math.min(i2UglyNum, Math.min(i3UglyNum, i5UglyNum));
            if (nextUglyNum == i2UglyNum)
                ++i2;
            if (nextUglyNum == i3UglyNum)
                ++i3;
            if (nextUglyNum == i5UglyNum)
                ++i5;
            uglyArr[i] = nextUglyNum;
        }
        return uglyArr[n];

    }

    public static void main(String[] args) {

        LC264 s = new LC264();
        System.out.println(s.nthUglyNumber(10));
        ;

    }
}
