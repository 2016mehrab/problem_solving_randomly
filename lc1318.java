class LC1318 {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        while (a != 0 || b != 0 || c!=0) {

            if (((a & 1) | (b & 1)) != (c & 1)) {
                if ((c & 1) == 0) {
                    flips += (a & 1) + (b & 1);
                }
                // c set bit =1
                else {
                    ++flips;

                }

            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return flips;
    }

    public static void main(String[] args) {
        LC1318 s = new LC1318();
        // System.out.println(s.minFlips(2, 6, 5));
        System.out.println(s.minFlips(2, 3, 5));
    }
}
