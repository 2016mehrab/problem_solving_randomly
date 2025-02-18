class LC2375 {

    private boolean smallestNumberImpl(int position, StringBuilder sb, String pattern, int rSize,
            boolean[] set) {
        if (position == rSize) {
            return true;
        }
        for (int i = 1; i <= rSize; ++i) {
            char det;
            if (set[i])
                continue;
            if (position != 0) {
                det = pattern.charAt(position - 1);
                if (det == 'I' && Integer.parseInt(""+sb.charAt(position - 1) ) > i)
                    continue;
                if (det == 'D' && Integer.parseInt(""+sb.charAt(position - 1) ) < i)
                    continue;
                sb.append( i+"");
                set[i] = true;
                if (smallestNumberImpl(position + 1, sb, pattern, rSize, set)) {
                    return true;
                }

            } else {
                sb.append( i+"");
                set[i] = true;
                if (smallestNumberImpl(position + 1, sb, pattern, rSize, set)) {
                    return true;
                }

            }
            // take

            // explore

            // skip
            sb.deleteCharAt(sb.length() - 1);
            set[i] = false;

        }
        return false;

    }

    public String smallestNumber(String pattern) {
        StringBuilder sb = new StringBuilder();
        boolean[] set = new boolean[10];
        smallestNumberImpl(0, sb, pattern, pattern.length() + 1, set);
        System.out.println(sb.toString());
        return null;
    }

    public static void main(String[] args) {
        LC2375 solution = new LC2375();
        solution.smallestNumber("IIIDIDDD");

    }
}
