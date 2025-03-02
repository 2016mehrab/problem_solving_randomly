import java.util.HashMap;
import java.util.Map;

class LC91 {
    private boolean isValid(String s, char[] encoding) {
        int idx = Integer.parseInt(s);
        if (idx > 0 && idx < encoding.length) {
            if (new String(idx + "").equals(s)) {
                return true;
            }
        }
        return false;
    }

    private int numDecodingsImpl(int start, StringBuilder sb, char[] encoding, Map<Integer, Integer> mp) {
        if (mp.containsKey(start)) {
            return mp.get(start);
        }
        if (start == sb.length()) {
            return 1;
        }
        if (start > sb.length()) {
            return 0;
        }
        int i = 0;
        if (start + 1 <= sb.length() && isValid(sb.substring(start, start + 1), encoding)) {
            i += numDecodingsImpl(start + 1, sb, encoding, mp);
        }
        if (start + 2 <= sb.length() && isValid(sb.substring(start, start + 2), encoding)) {
            i += numDecodingsImpl(start + 2, sb, encoding, mp);
        }
        mp.put(start, i);
        return i;
    }

    public int numDecodings(String s) {
        StringBuilder sb = new StringBuilder(s);
        Map<Integer, Integer> mp = new HashMap<>();
        char[] encoding = new char[27];
        for (int i = 0; i < 26; ++i)
            encoding[i + 1] = (char) ((int) 'A' + i);
        // for (int i = 1; i < 27; ++i)
        // System.out.println(encoding[i] + " = " + i);
        int r = numDecodingsImpl(0, sb, encoding, mp);
        System.out.println(r);
        return r;
    }

    public static void main(String[] args) {
        LC91 solution = new LC91();
        solution.numDecodings("12");
        solution.numDecodings("226");
        solution.numDecodings("06");
        solution.numDecodings("11106");
        solution.numDecodings("111111111111111111111111111111111111111111111");
    }
}
