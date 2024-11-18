class LC1652 {

    public int[] decrypt(int[] code, int k) {
        int[] decryptCode = new int[code.length];
        int left = 0;
        int sum = 0;
        int N = code.length;
        for (int right = 0; right < code.length + Math.abs(k) - 1; ++right) {
            sum += code[right % N];
            if (right - left + 1 > Math.abs(k)) {
                sum -= code[left % N];
                ++left;
            }
            if (right - left + 1 == Math.abs(k)) {
                if (k == 0) {
                    return decryptCode;
                }
                if (k > 0) {
                    decryptCode[(left - 1 + N) % N] = sum;
                } else {
                    decryptCode[(right + 1) % N] = sum;

                }
            }

        }
        for (int i : decryptCode) {
            System.out.println(i);
        }
        return decryptCode;

    }

    public static void main(String[] args) {

        LC1652 s = new LC1652();
        int[] p = { 5, 7, 1, 4 };
        int[] n = { 2, 4, 9, 3 };
        // s.decrypt(p, 3);
        s.decrypt(n, -2);
    }

}
