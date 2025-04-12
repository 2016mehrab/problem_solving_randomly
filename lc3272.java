import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class LC3272 {
    private static final Map<Integer, Long> cache = new HashMap<>();

    private String generatePalindrome(String firstHalf, int n) {

        StringBuilder sb = new StringBuilder(firstHalf);
        int start = n % 2 == 0 ? firstHalf.length() - 1 : firstHalf.length() - 2;
        for (int i = start; i >= 0; --i) {
            sb.append(firstHalf.charAt(i));
        }
        return sb.toString();
    }

    public long countGoodIntegers(int n, int k) {
        int halflen = (n + 1) / 2;
        long start = pow(10, n - 1);
        long end = pow(10, n) - 1;

        long minHalf = pow(10, halflen - 1);
        long maxHalf = pow(10, halflen) - 1;

        Set<String> list = new HashSet<>();

        for (long i = minHalf; i <= maxHalf; ++i) {
            String firstHalf = String.valueOf(i);
            String palindrome = generatePalindrome(firstHalf, n);
            long num = Long.parseLong(palindrome);

            if (num >= start && num <= end && num % k == 0) {
                char[] charArr = palindrome.toCharArray();
                Arrays.sort(charArr);
                list.add(new String(charArr));
            }
        }
        long r = 0;
        for (var l : list) {
            int[] digits = new int[10];
            for (int i = 0; i < l.length(); ++i) {
                digits[l.charAt(i) - '0']++;
            }
            r += permutation(n, digits);
        }

        System.out.println(r);
        return r;
    }

    public long countGoodIntegers2(int n, int k) {
        long start = pow(10, n - 1);
        long end = pow(10, n) - 1;
        Set<String> list = new HashSet<>();

        // find a good integer
        // get all its permutation because each of them can be rearranged to form a
        // k-palindromic integer
        for (long i = start; i <= end; ++i) {
            String original = String.valueOf(i);
            if (isKPalindrome(original, k)) {
                char[] charArr = original.toCharArray();
                Arrays.sort(charArr);
                list.add(new String(charArr));
            }
        }
        long r = 0;
        for (var l : list) {
            int[] digits = new int[10];
            for (int i = 0; i < l.length(); ++i) {
                digits[l.charAt(i) - '0']++;
            }
            r += permutation(n, digits);
        }

        System.out.println(r);
        return r;
    }

    private boolean isKPalindrome(String str, int k) {
        int len = str.length();
        int half = len / 2;
        for (int i = 0; i < half; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return false;
            }
        }
        return Long.parseLong(str) % k == 0;
    }

    // slots = total digits
    private long permutation(int slots, int[] digits) {
        long result = 0;
        // ____ 1,2,3, 4,5, 9p4
        int nonZeroDigits = slots - digits[0];
        if (nonZeroDigits > 0) {
            result = nonZeroDigits * factorial((slots - 1)) / factorial(slots - 1 - slots);
        } else {
            result = factorial(slots) / factorial(slots - slots);
        }
        for (var d : digits) {
            result /= factorial(d);
        }
        return result;

    }

    private long factorial(int n) {
        if (n <= 1)
            return 1;
        if (cache.containsKey(n))
            return cache.get(n);
        cache.put(n, n * factorial(n - 1));
        return cache.get(n);
    }

    private long pow(int base, int exp) {
        if (exp == 0)
            return 1;
        long res;
        long half = pow(base, exp / 2);
        res = half * half;
        if (exp % 2 == 1)
            res *= base;
        return res;
    }

    public static void main(String[] args) {
        LC3272 solution = new LC3272();
        solution.countGoodIntegers(3, 5);
        solution.countGoodIntegers(7, 4);
        solution.countGoodIntegers(8, 1);

        // System.out.println(solution.isKPalindrome("2002", 2));
        // System.out.println(solution.isKPalindrome("101", 2));
        // System.out.println(solution.isKPalindrome("2024", 2));
        // int[] digits = new int[] { 0, 2, 1, 0, 0, 1, 0, 0, 0 };
        // System.out.println(solution.permutation(3, digits));
        // System.out.println(solution.permutation(9, 2, null));
        // System.out.println(solution.factorial(4));
        // System.out.println(solution.factorial(5));
        ;

    }
}
