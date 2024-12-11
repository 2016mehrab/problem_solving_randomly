class LC2982 {
    public static void printMatrix(int[][] matrix) {
        System.out.println();
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
        System.out.println("<--------------------------------------------->");
    }

    public int maximumLength(String s) {
        int r = -1;
        int N = s.length();
        int[][] arr = new int[26][N + 1];
        int count = 1;
        StringBuilder sb = new StringBuilder(s);
        for (int i = N - 1; i >= 0; --i) {
            if (i < N - 1 && sb.charAt(i) == sb.charAt(i + 1)) {
                ++count;
            } else {
                count = 1;
            }
            arr[sb.charAt(i) - 'a'][count] += 1;
        }
        for (int[] row : arr) {
            int cusum = 0;
            int i = row.length - 1;
            while (i >= 0) {
                cusum += row[i];
                if (cusum >= 3) {
                    r = r > i ? r : i;
                    break;
                }
                --i;
            }
        }
        System.out.println("result->" + r);

        return r;
    }

    public static void main(String[] args) {
        LC2982 solution = new LC2982();
        solution.maximumLength("aaaa");
        solution.maximumLength("abcaba");
        solution.maximumLength("abcdef");

    }
}
