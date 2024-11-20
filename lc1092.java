import java.util.HashMap;
import java.util.Map;

class LC1092 {
    private Map<String, String> memoized = new HashMap<>();

    public String solve(int s1, int s2, String str1, String str2) {
        String key = s1 + "-" + s2;
        if (memoized.containsKey(key)) {
            return memoized.get(key);
        }

        if (s1 >= str1.length()) {
            return str2.substring(s2);
        }
        if (s2 >= str2.length()) {
            return str1.substring(s1);
        }
        if (str1.charAt(s1) == str2.charAt(s2)) {
            String result = str1.charAt(s1) + solve(s1 + 1, s2 + 1, str1, str2);
            memoized.put(key, result);
            return result;

        } else {
            String superseq_1 = (str1.charAt(s1) + "" + solve(s1 + 1, s2, str1, str2));
            String superseq_2 = (str2.charAt(s2) + "" + solve(s1, s2 + 1, str1, str2));
            int size_1 = superseq_1.length();
            int size_2 = superseq_2.length();

            memoized.put(key, size_1 > size_2 ? superseq_2 : superseq_1);
            return memoized.get(key);

        }

    }

    public String shortestCommonSupersequence(String str1, String str2) {
        int ROWS = str1.length() + 1;
        int COLS = str2.length() + 1;
        int[][] matrix = new int[ROWS][COLS];
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                if (row == 0 || col == 0) {
                    matrix[row][col] = row + col;
                } else if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                    matrix[row][col] = matrix[row - 1][col - 1] + 1;
                } else {
                    matrix[row][col] = Math.min(matrix[row - 1][col], matrix[row][col - 1]) + 1;
                }
            }
        }
        System.out.println("[+] "+matrix[ROWS - 1][COLS - 1]);
        String superseq = "";
        int row = ROWS - 1;
        int col = COLS - 1;
        while (row > 0 && col > 0) {
             if (row >0 && col >0 && str1.charAt(row-1) == str2.charAt(col-1)) {
                superseq = str1.charAt(row-1) + superseq;
                --row;
                --col;
                continue;
            } else {
                
                // superseq = str1.charAt(row-1)+"" + str2.charAt(col-1)+superseq;
                if(matrix[row - 1][col] < matrix[row][col - 1] ){
                superseq = str1.charAt(row-1)+""  +superseq;
                    --row;
                }
                else{
                superseq = str2.charAt(col-1)+""  +superseq;
                    --col;

                }
            }

        }
        if(col==0){
            while(row>0){
                superseq = str1.charAt(row-1)+""  +superseq;
                --row;
            }
        }
        else{
            while(col>0){
                superseq = str2.charAt(col-1)+""  +superseq;
                --col;
            }

        }
        System.out.println("[+] "+superseq);
        return superseq;

    }

    public String shortestCommonSupersequenceTree(String str1, String str2) {
        return solve(0, 0, str1, str2);

    }

    public static void main(String[] args) {
        LC1092 s = new LC1092();
        s.shortestCommonSupersequence("ifgh", "jghi");

    }

}
