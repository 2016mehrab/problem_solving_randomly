class LC1861 {

    public static void printMatrix(char[][] matrix) {
        System.out.println();
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
        System.out.println("<--------------------------------------------->");
    }

    public char[][] rotateTheBox(char[][] box) {
        int ROWS = box.length;
        int COLS = box[0].length;
        char[][] rotatedMatrix = new char[COLS][ROWS];
        printMatrix(box);
        for (int r = 0; r < ROWS; ++r) {
            int air = COLS - 1;
            for (int c = COLS - 1; c > -1; --c) {
                if (box[r][c] == '#') {
                    char tmp = box[r][c];
                    box[r][c] = box[r][air];
                    box[r][air] = tmp;
                    --air;
                } else if (box[r][c] == '*') {
                    air = c - 1;
                }
            }
        }

        printMatrix(box);
        for (int c = 0; c < COLS; c++) {
            for (int r = ROWS - 1; r > -1; --r) {
                rotatedMatrix[c][ROWS - 1 - r] = box[r][c];
            }
        }

        printMatrix(rotatedMatrix);
        return box;

    }

    public static void main(String[] args) {
        LC1861 solution = new LC1861();
        char[][] box = {
                { '#', '#', '*', '.', '*', '.' },
                { '#', '#', '#', '*', '.', '.' },
                { '#', '#', '#', '.', '#', '.' }
        };
        solution.rotateTheBox(box);
    }
}
