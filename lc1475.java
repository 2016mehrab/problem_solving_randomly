import java.util.Arrays;

class LC1475 {
    public int[] finalPrices(int[] prices) {
        int N = prices.length;
        // holds indexes of larger elements
        int[] q = new int[N + 1];
        int ptr = 0;
        for (int i = 0; i < N; ++i) {
            if (ptr != 0) {
                while (ptr > 0 && prices[q[ptr - 1]] >= prices[i]) {
                    prices[q[ptr - 1]] = prices[q[ptr - 1]] - prices[i];
                    --ptr;
                }
                q[ptr++] = i;
            } else
                q[ptr++] = i;
        }
        Arrays.stream(prices).forEach(System.out::println);
        return prices;
    }

    public static void main(String[] args) {
        LC1475 solution = new LC1475();
        int[] p1 = { 8, 4, 6, 2, 3 };
        int[] p2 = { 1, 2, 3, 4, 5 };
        solution.finalPrices(p1);
        solution.finalPrices(p2);

    }
}
