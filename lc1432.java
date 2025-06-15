class LC1432 {
    public int maxDiff(int num) {
        // get max A
        String numStr = Integer.toString(num);
        int N = numStr.length();
        StringBuilder a = new StringBuilder(numStr);
        StringBuilder b = new StringBuilder(numStr);
        // replace first non 9 with 9
        int replaceIdx = -1;
        for (int i = 0; i < N; ++i) {
            if (numStr.charAt(i) != '9') {
                replaceIdx = i;
                break;
            }
        }
        if (replaceIdx != -1) {
            for (int i = replaceIdx; i < N; ++i) {
                if (numStr.charAt(i) == numStr.charAt(replaceIdx)) {
                    a.setCharAt(i, '9');
                }
            }
        }

        // get min b
        var minDigit = numStr.charAt(0);
        char replace = '1';

        if (minDigit == '1') {
            for (int i = 1; i < N; ++i) {
                if (numStr.charAt(i) != '0' && numStr.charAt(i) != '1') {
                    minDigit = numStr.charAt(i);
                    replace = '0';
                    break;
                }
            }

        }

        for (int i = 0; i < N; ++i) {
            if (numStr.charAt(i) == minDigit)
                b.setCharAt(i, replace);
        }

        return Integer.parseInt(a.toString()) - Integer.parseInt(b.toString());
    }

    public static void main(String[] args) {
        LC1432 solution = new LC1432();

    }
}
