class LC168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            --columnNumber;
            int r = columnNumber % 26;
            sb.append((char) ('A' + r));
            columnNumber /= 26;
        }
        sb.reverse();
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        LC168 solution = new LC168();
        solution.convertToTitle(1);
        solution.convertToTitle(28);
        solution.convertToTitle(701);
        solution.convertToTitle(52);

    }
}
