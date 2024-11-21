class LC2257 {

    public static void printMatrix(int[][] matrix) {
        System.out.println(); // Move to the next row
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "\t"); // Use tab for alignment
            }
            System.out.println(); // Move to the next row
        }
        System.out.println("<--------------------------------------------->"); // Move to the next row
    }

    public void detect(int r, int c, int[][] matrix) {

        // detect down
        for (int row = r + 1; row < matrix.length; ++row) {
            if (matrix[row][c] == 2 || matrix[row][c] == 1) {
                break;
            }
            matrix[row][c] = 3;
        }
        // detect up
        for (int row = r - 1; row > -1; --row) {
            if (matrix[row][c] == 2 || matrix[row][c] == 1) {
                break;
            }
            matrix[row][c] = 3;
        }

        for (int col = c + 1; col < matrix[0].length; ++col) {
            if (matrix[r][col] == 2 || matrix[r][col] == 1) {
                break;
            }
            matrix[r][col] = 3;
        }
        for (int col = c - 1; col > -1; --col) {
            if (matrix[r][col] == 2 || matrix[r][col] == 1) {
                break;
            }
            matrix[r][col] = 3;
        }

    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

        int undetected = 0;
        int[][] cells = new int[m][n];
        for (int[] guard : guards) {
            cells[guard[0]][guard[1]] = 1;
        }
        for (int[] wall : walls) {
            cells[wall[0]][wall[1]] = 2;
        }
        printMatrix(cells);

        for (int[] guard : guards) {
            detect(guard[0], guard[1], cells);
        }
        for (int[] row : cells) {
            for (int col : row) {
                if (col == 0) {
                    ++undetected;
                }
            }
        }

        printMatrix(cells);
        System.out.println(undetected);
        return undetected;

    }

    public static void main(String[] args) {
        LC2257 s = new LC2257();
        int m1 = 4;
        int n1 = 6;
        int[][] g1 = {
                { 0, 0 },
                { 1, 1 },
                { 2, 3 }
        };
        int[][] w1 = {
                { 0, 1 },
                { 2, 2 },
                { 1, 4 }
        };

        s.countUnguarded(m1, n1, g1, w1);

    }
}
