import java.util.HashSet;
import java.util.Set;

class LC2657 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int N = A.length;
        int[] r = new int[N];
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; ++i) {
            set.add(i);
        }
        r[N - 1] = N;
        for (int i = N - 1; i > -1; --i) {
            if (i == N - 1)
                continue;
            if (set.contains(A[i + 1])) {
                set.remove(A[i + 1]);
            }
            if (set.contains(B[i + 1])) {
                set.remove(B[i + 1]);
            }
            r[i] = set.size();
        }

        return r;
    }

    public static void main(String[] args) {
        LC2657 solution = new LC2657();
        int[] a1 = { 1, 3, 2, 4 };
        int[] b1 = { 3, 1, 2, 4 };
        solution.findThePrefixCommonArray(a1, b1);

    }
}
