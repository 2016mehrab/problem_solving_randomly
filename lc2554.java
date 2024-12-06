import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LC2554 {
    public int maxCount(int[] banned, int n, int maxSum) {
        int count = 0;
        int sum = 0;
        HashSet<Integer> set = IntStream.of(banned).boxed().collect(Collectors.toCollection(HashSet::new));
        for (int i = 1; i <= n; ++i) {
            if (!set.contains(i) && ((i + sum) <= maxSum)) {
                sum += i;
                ++count;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        LC2554 solution = new LC2554();
        int[] b = { 1, 2, 3, 4, 5, 6, 7 };
        int[] b1 = { 11 };
        solution.maxCount(b, 8, 1);
        solution.maxCount(b1, 7, 50);

    }
}
