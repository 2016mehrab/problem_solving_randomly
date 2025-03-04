class LC1780 {
    public boolean checkPowersOfThree(int n) {
        int p = 0;
        while (n > 0) {
            if (n % 3 > 1)
                return false;
            n /= 3;
        }

        return true;
    }

    public static void main(String[] args) {
        LC1780 solution = new LC1780();
        System.out.println(solution.checkPowersOfThree(12));
        System.out.println(solution.checkPowersOfThree(91));
        System.out.println(solution.checkPowersOfThree(21));
        System.out.println(solution.checkPowersOfThree(6));

    }
}
