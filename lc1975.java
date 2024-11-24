import java.util.Arrays;

class LC1975 {
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

    public static int[][] convertStringTo2DArray(String input) {
        // Step 1: Remove the outer square brackets
        input = input.trim().substring(1, input.length() - 1);

        // Step 2: Split the string into rows using "],[" as the delimiter
        String[] rows = input.split("\\],\\[");

        // Step 3: Create the resulting 2D int array
        int[][] result = new int[rows.length][];

        // Step 4: Process each row
        for (int i = 0; i < rows.length; i++) {
            // Remove any remaining square brackets
            rows[i] = rows[i].replace("[", "").replace("]", "");

            // Split the row into individual numbers
            String[] numbers = rows[i].split(",");

            // Convert the numbers to integers and store in the result array
            result[i] = Arrays.stream(numbers)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return result;
    }

    public long maxMatrixSum(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int negativeCount = 0;
        long absoluteSum = 0;
        int minimum = Integer.MAX_VALUE;
        for (int r = 0; r < ROWS; ++r) {
            for (int c = 0; c < COLS; ++c) {
                absoluteSum += Math.abs(matrix[r][c]);
                if (Math.abs(matrix[r][c]) < minimum) {
                    minimum = Math.abs(matrix[r][c]);
                }
                if (matrix[r][c] < 0) {
                    ++negativeCount;
                }

            }
        }
        System.out.println("absoluteSum " + absoluteSum + " negativeCount " + negativeCount + " minimum " + minimum);
        if (negativeCount % 2 != 0) {
            absoluteSum += (minimum * -1) * 2;

        }
        System.out.println("absoluteSum " + absoluteSum + " negativeCount " + negativeCount + " minimum " + minimum);

        return absoluteSum;
    }

    public static void main(String[] args) {
        LC1975 solution = new LC1975();
        int[][] matrix = convertStringTo2DArray("[[1,2,3],[-1,-2,-3],[1,2,3]]");
        solution.maxMatrixSum(matrix);
    }
}
