//s consists of only 0 and 1
//split s into 2 NON-EMPTY substrings
//score = count of 0 in the left substr

//s= 011101
//starting with index i:
//    score =count the score in the left substring till index i + count the score in the right substring after index i
//    keep track of the max score
//
//return max score

class LC1422 {
    private int getScore(int idx, StringBuilder sb) {
        int r = 0;
        for (int i = 0; i < idx; ++i) {
            if (sb.charAt(i) == '0')
                ++r;
        }
        for (int i = idx; i < sb.length(); ++i) {
            if (sb.charAt(i) == '1')
                ++r;
        }
        return r;
    }

    public int maxScoreBF(String s) {
        StringBuilder sb = new StringBuilder(s);
        int len = sb.length();
        int score = -1;
        for (int i = 1; i < len; ++i) {
            score = Math.max(score, getScore(i, sb));
        }
        System.out.println(score);
        return score;

    }

    public int maxScore(String s) {
        StringBuilder sb = new StringBuilder(s);
        int len = sb.length();
        int score = -1;
        int tmp = 0;
        for (int i = 1; i < len; ++i) {
            if (i == 1) {
                tmp = Math.max(score, getScore(i, sb));
            } else {
                if (sb.charAt(i - 1) == '1')
                    --tmp;
                else
                    ++tmp;
            }
            score = Math.max(tmp, score);
        }
        System.out.println(score);
        return score;

    }

    public static void main(String[] args) {
        LC1422 solution = new LC1422();
        solution.maxScore("011101");
        solution.maxScore("00111");
        solution.maxScore("1111");

    }
}
