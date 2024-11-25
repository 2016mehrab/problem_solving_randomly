import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class LC773 {
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

    public int slidingPuzzle(int[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;
        String initial = "";
        String expected = "123450";
        Queue<String> queue = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> moves = new HashMap<>();
        Set<String> visited = new HashSet<>();
        int levels = 0;

        for (int r = 0; r < ROWS; ++r) {
            for (int c = 0; c < COLS; ++c) {
                initial += board[r][c];
            }
        }
        queue.add(initial);
        moves.put(0, new ArrayList<>(Arrays.asList(1, 3)));
        moves.put(1, new ArrayList<>(Arrays.asList(0, 2, 4)));
        moves.put(2, new ArrayList<>(Arrays.asList(1, 5)));
        moves.put(3, new ArrayList<>(Arrays.asList(0, 4)));
        moves.put(4, new ArrayList<>(Arrays.asList(1, 3, 5)));
        moves.put(5, new ArrayList<>(Arrays.asList(2, 4)));
        while (!queue.isEmpty()) {
            int states = queue.size();
            while (states > 0) {
                String curr = queue.remove();
                visited.add(curr);
                if (curr.equals(expected)) {
                    return levels;
                }
                int index = curr.indexOf('0');
                for (int swapIndex : moves.get(index)) {
                    String newState = swapChar(curr, swapIndex, index);
                    if (!visited.contains(newState)) {

                        queue.add(newState);
                    }
                }
                --states;
            }
            ++levels;
        }
        return -1;
    }

    public String swapChar(String s, int index1, int index2) {
        char[] newStr = s.toCharArray();
        char tmp = s.charAt(index2);
        newStr[index2] = newStr[index1];
        newStr[index1] = tmp;
        return new String(newStr);
    }

    public static void main(String[] args) {
        LC773 solution = new LC773();
        int[][] matrix = convertStringTo2DArray("[[1,2,3],[4,0,5]]");
        System.out.println(solution.slidingPuzzle(matrix));
    }
}
