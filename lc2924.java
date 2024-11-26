import java.util.Arrays;


class LC2924 {
    public static int[][] convertStringTo2DArray(String input) {
        input = input.trim().substring(1, input.length() - 1);
        String[] rows = input.split("\\],\\[");
        int[][] result = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = rows[i].replace("[", "").replace("]", "");
            String[] numbers = rows[i].split(",");
            result[i] = Arrays.stream(numbers)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return result;
    }


    public int findChampion(int n, int[][] edges) {
        int[] set = new int[n];
        for (int[] edge : edges) {
            set[edge[1]] = 1;
        }
        int non_unique = 0;
        int champion = -1;
        for (int var : set) {
            if (var == 1)
                ++non_unique;
            else {
                champion = var;
            }
        }
        if (non_unique + 1 == n) {
            return champion;
        }

        return -1;

    }

    public static void main(String[] args) {
        LC2924 solution = new LC2924();
        int[][] e1 = convertStringTo2DArray("[[0,2],[1,3],[1,2]]");
        int[][] e2 = convertStringTo2DArray("[[0,1],[1,2]]");
        int[][] e3 = convertStringTo2DArray("[[1,0]]");
        System.out.println(solution.findChampion(2, e3));
        // System.out.println(solution.findChampion(4, e1));
        // System.out.println(solution.findChampion(3, e2));
    }
}
