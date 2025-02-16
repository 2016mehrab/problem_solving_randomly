import java.util.Arrays;

class LC1718 {
    private boolean solve(int position, int num, int[] result, boolean[] visited) {
        if (position >= result.length) {
            return true;
        }
        if (result[position] != -1) {
            return solve(position + 1, num, result, visited);
        }
        for (int n = num; n > 0; --n) {
            if (visited[n]) {
                continue;
            }
            result[position] = n;
            visited[n] = true;
            int nextPosition = position + n;
            if (n != 1) {
                if (nextPosition >= result.length) {
                    visited[n] = false;
                    result[position] = -1;
                    return false;
                }
                if (result[nextPosition] != -1) {
                    visited[n] = false;
                    result[position] = -1;
                    continue;
                }
                result[nextPosition] = n;
                if (solve(position + 1, num, result, visited))
                    return true;
                else {
                    visited[n] = false;
                    result[position] = -1;
                    result[nextPosition] = -1;
                }
            } else {
                if (solve(position + 1, num, result, visited))
                    return true;
                else {
                    visited[n] = false;
                    result[position] = -1;
                }
            }

        }
        return false;
    }

    public int[] constructDistancedSequence(int n) {
        int[] r = new int[2 * n - 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(r, -1);
        solve(0, n, r, visited);
        return r;

    }

    public static void main(String[] args) {
        LC1718 solution = new LC1718();
        System.out.println(Arrays.toString(solution.constructDistancedSequence(3)));
        ;

    }
}
