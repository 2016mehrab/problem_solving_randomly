class LC2683 {
    public boolean doesValidArrayExist(int[] derived) {
        int r = 0;
        for (int i : derived)
            r ^= i;

        System.out.println(r);
        return r != 1;
    }

    public static void main(String[] args) {
        LC2683 solution = new LC2683();
        int[] d1 = { 1, 1, 0 };
        int[] d2 = { 1, 1, 1, 0, 0 };
        int[] d3 = { 1, 1, 1, 1, 0, 0 };
        solution.doesValidArrayExist(d1);
        solution.doesValidArrayExist(d2);
        solution.doesValidArrayExist(d3);

    }
}
