import java.util.HashMap;
import java.util.Map;

class LC1072 {

    static void printArray(int[] arr) {

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

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

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        printMatrix(matrix);
        int equalRows = 0;
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        Map<String, Integer> map = new HashMap<>();

        for (int r = 0; r < ROWS; ++r) {
            String key = "";
            int firstElement = matrix[r][0];
            for (int c = 0; c < COLS; ++c) {
                key += (firstElement == matrix[r][c]) ? "S" : "D";
            }
            System.out.println("Key " + key); // Move to the next row
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {

                map.put(key, 1);
            }
            equalRows = Math.max(equalRows, map.get(key));
        }
        System.out.println("Ans " + equalRows); // Move to the next row
        return equalRows;
    }

    public static void main(String[] args) {
        LC1072 s = new LC1072();
        int[][] matrix = {
                { 0, 0, 1, 0, 0, 1 },
                { 0, 0, 1, 0, 0, 1 },
                { 0, 0, 1, 0, 0, 1 },
                { 0, 0, 1, 0, 0, 1 },
                { 1, 1, 0, 1, 0, 0 },
        };
        s.maxEqualRowsAfterFlips(matrix);
    }
}
