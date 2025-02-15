import java.util.Arrays;

class LC2698 {
    private boolean isPossible(int idx, StringBuilder sb, int sum, int target) {
        if (idx > sb.length()) return false;
        if (idx == sb.length() && sum == target) {
            return true;
        }
        if (sum > target) {
            return false;
        }
        for (int i = idx; i < sb.length(); ++i) {
            // do partition on the rest of the string
            int val =Integer.parseInt(sb.substring(idx, i + 1));
            if (isPossible(idx + 1, sb, sum +val , target)) {
                return true;
            }
        }
        return false;

    }

    public int punishmentNumber(int n) {
        int p = 0;
        for (int i = 1; i <= n; ++i) {
            int sq = i * i;
            StringBuilder sb = new StringBuilder("" + sq);
            if (isPossible(0, sb, 0, i)) {
                p += sq;
            }

        }
        System.out.println(p);
        return p;

    }

    public static void main(String[] args) {
        LC2698 solution = new LC2698();
        solution.punishmentNumber(10);

    }
}
