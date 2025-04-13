
class LC1922 {

    private static final int MOD = 1000000007;

    public int countGoodNumbers(long n) {
        // int[] primeDigits = new int[] { 2, 3, 5, 7 };
        // int[] evenDigits = new int[] { 0, 2, 4, 6, 8 };
        int evenDigits = 5;
        int primeDigits = 4;
        long r = 1;
        long evenPos = n / 2;
        long oddPos = n / 2;
        if (n % 2 == 1) {
            ++evenPos;
        }
        r = pow(evenDigits, evenPos);
        r = (r * pow(primeDigits, oddPos)) % MOD;
        System.out.println((int) r);
        return (int) r;
    }

    private int pow(int base, long exp) {
        if (exp == 0)
            return 1;
        long res = 1;
        long half = pow(base, exp / 2);
        res = (half * half) % MOD;
        if (exp % 2 == 1)
            res = (res * base) % MOD;
        return (int) res;
    }

    public static void main(String[] args) {
        LC1922 solution = new LC1922();
        solution.countGoodNumbers(1);
        solution.countGoodNumbers(4);
        solution.countGoodNumbers(50);

    }
}
