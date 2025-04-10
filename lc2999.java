class LC2999 {

    private long solve(String str, int limit, String suffix) {
        if (str.length() < suffix.length())
            return 0;
        long total = 0;
        String StrSuffix = str.substring(str.length() - suffix.length());
        int slots = str.length() - suffix.length();
        for (int i = 0; i < slots; ++i) {
            int digit = str.charAt(i) - '0';
            if (digit > limit) {
                total += calcPow((limit + 1), slots - i);
                return total;
            } else {
                total += digit * calcPow((limit + 1), slots - i - 1);
            }
        }
        // the equal number gets added here
        if (Long.parseLong(StrSuffix) >= Long.parseLong(suffix))
            ++total;
        return total;
    }

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        // long sVal = Long.parseLong(s);
        // long r = 0;
        //// finish=2000 suffix = "3000"
        // if (sVal >= finish)
        // return r;

        String startStr = new String((start - 1) + "");
        String finishStr = new String(finish + "");
        return solve(finishStr, limit, s) - solve(startStr, limit, s);
    }

    private long calcPow(int base, int exp) {
        if (exp == 0)
            return 1;
        long half = calcPow(base, exp / 2);
        long res = half * half;
        if (exp % 2 == 1)
            res *= base;
        return res;
    }

    public static void main(String[] args) {
        LC2999 solution = new LC2999();
        solution.numberOfPowerfulInt(1, 6000, 4, "124");
        solution.numberOfPowerfulInt(15, 215, 6, "10");
        solution.numberOfPowerfulInt(1000, 2000, 4, "3000");
        solution.numberOfPowerfulInt(1, 971, 9, "72");

    }
}
