class LC2109 {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder r = new StringBuilder();
        int spaceIndex = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (spaceIndex < spaces.length && i == spaces[spaceIndex]) {
                r.append(' ');
                ++spaceIndex;
            }
            r.append(s.charAt(i));
        }
        System.out.println(r.toString());
        return r.toString();

    }

    public static void main(String[] args) {
        LC2109 solution = new LC2109();
        int[] s1 = { 8, 13, 15 };
        int[] s2= { 1,5,7,9 };
        int[] s3 =  { 0,1,2,3,4,5,6 };
        solution.addSpaces("LeetcodeHelpsMeLearn", s1);
        solution.addSpaces("icodeinpython", s2);
        solution.addSpaces("spacing", s3);

    }
}
