class LC2566 {
    public int minMaxDifferenceBuiltin(int num) {
        String sbmax = new String(Integer.toString(num));
        String sbmin = new String(Integer.toString(num));
        int pos = 0;
        int N = sbmax.length();
        while (pos < N && sbmax.charAt(pos) == '9') {
            ++pos;
        }
        if (pos < N)
            sbmax = sbmax.replace(sbmax.charAt(pos), '9');
        // first char can't be 0
        sbmin = sbmin.replace(sbmin.charAt(0), '0');
        return Integer.parseInt(sbmax.toString()) - Integer.parseInt(sbmin.toString());

    }

    public int minMaxDifference(int num) {
        var str = Integer.toString(num);
        int N = str.length();
        // max
        StringBuilder a = new StringBuilder(str);
        // min
        StringBuilder b = new StringBuilder(str);

        // find first non 9 and convert to 9
        int pos = -1;
        for (int i = 0; i < N; ++i) {
            if (str.charAt(i) != '9') {
                pos = i;
                break;
            }
        }
        if (pos != -1) {
            for (int i = pos; i < N; ++i) {
                if (str.charAt(i) == str.charAt(pos))
                    a.setCharAt(i, '9');
            }
        }
        pos = 0;
        for (int i = pos; i < N; ++i) {
            if (str.charAt(i) == str.charAt(pos))
                b.setCharAt(i, '0');
        }

        return Integer.parseInt(a.toString()) - Integer.parseInt(b.toString());

    }

    public static void main(String[] args) {
        LC2566 solution = new LC2566();
        solution.minMaxDifference(11891);
        solution.minMaxDifference(90);

    }
}
