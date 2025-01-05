import java.util.Arrays;

class LC2381 {
    public String shiftingLetters(String s, int[][] shifts) {
        int N = s.length();
        int[] position = new int[N];
        for (int[] query : shifts) {
            if (query[2] == 0) {
                position[query[0]] -= 1;
            } else {
                position[query[0]] += 1;
            }
            if (query[1] + 1 < N) {

                if (query[2] == 0) {
                    position[query[1] + 1] += 1;
                } else {
                    position[query[1] + 1] -= 1;
                }
            }
        }
        for (int i = 1; i < N; ++i) {
            position[i] += position[i - 1];
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < N; ++i) {
            int shiftedChar = (((26 + sb.charAt(i) - 97 + position[i]) % 26) + 97);
            sb.setCharAt(i, (char) shiftedChar);
        }

        // for (byte i : position)
        // System.out.println(i);
        System.out.println(sb.toString());
        return sb.toString();

    }

    public String shiftingLettersB(String s, int[][] shifts) {
        int N = s.length();
        byte[] position = new byte[N];
        for (int[] query : shifts) {
            if (query[2] == 0) {
                --position[query[0]];
                if (query[1] + 1 < N) {
                    ++position[query[1] + 1];
                }

            } else {
                ++position[query[0]];
                if (query[1] + 1 < N) {
                    --position[query[1] + 1];
                }
            }
        }

        StringBuilder sb = new StringBuilder(s);
        int sum = 0;
        // wrong
        // for (int i = 0; i < N; ++i) {
        // sum = (sum + position[i ] + 26) % 26;
        // int originalChar = (sb.charAt(i) - 97);
        // int shiftedChar = ((originalChar + sum) % 26) + 97;
        // sb.setCharAt(i, (char) shiftedChar);
        //
        // }
        for (int i = 0; i < N; ++i) {
            sum = (sum + position[i]) % 26;
            if (sum < 0)
                sum += 26;
            int originalChar = (sb.charAt(i) - 'a');
            int shiftedChar = ((originalChar + sum) % 26) + 'a';
            sb.setCharAt(i, (char) shiftedChar);

        }

        // for (byte i : position)
        // System.out.println(i);
        System.out.println(sb.toString());
        return sb.toString();

    }

    public static void main(String[] args) {
        LC2381 solution = new LC2381();
        int[][] sh1 = { { 0, 1, 0 }, { 1, 2, 1 }, { 0, 2, 1 } };
        int[][] sh2 = { { 0, 0, 0 }, { 1, 1, 1 } };
        solution.shiftingLettersB("abc", sh1);
        solution.shiftingLettersB("dztz", sh2);

    }
}
