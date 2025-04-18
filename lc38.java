class LC38 {
    public String countAndSay(int n) {

        if (n == 1)
            return "1";
        StringBuilder sb = new StringBuilder();
        String say = countAndSay(n - 1);

        // RLE
        for (int i = 0; i < say.length(); ++i) {
            int cnt = 1;
            var ch = say.charAt(i);
            while (i < say.length() - 1 && say.charAt(i) == say.charAt(i + 1)) {
                ++cnt;
                ++i;
            }
            sb.append(cnt);
            sb.append(ch);
        }
        System.out.println(n + "->" + sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        LC38 solution = new LC38();
        solution.countAndSay(4);

    }
}
