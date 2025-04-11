class LC2843 {
    public int countSymmetricIntegers(int low, int high) {
        int r = 0;
        for (int i = low; i <= high; ++i) {
            if (i > 10 && i < 100) {
                if (i % 11 == 0)
                    ++r;
            }
            if (i > 1000 && i < 10000) {
                String s = new String(i + "");
                if (s.length() % 2 == 0) {
                    // end exclusive
                    int halfSum = sum(s, s.length() / 2);
                    int fullSum = sum(s, s.length());
                    if (halfSum * 2 == fullSum)
                        ++r;
                }
            }
        }
        return r;
    }

    private int sum(String s, int idx) {
        int sum = 0;
        for (int i = 0; i < idx; ++i) {
            int digit = s.charAt(i) - '0';
            sum += digit;
        }
        return sum;
    }

    public static void main(String[] args) {
        LC2843 solution = new LC2843();
        solution.countSymmetricIntegers(1, 100);
        solution.countSymmetricIntegers(1200, 1230);

    }
}
