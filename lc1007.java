class LC1007 {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // nums 1,2,3,4,5,6

        int minSwap = -1;
        for (int i = 1; i <= 6; ++i) {
            int topSwap = 0;
            int bottomSwap = 0;
            for (int j = 0; j < tops.length; ++j) {
                // i is not in all dominoes
                if (tops[j] != i && bottoms[j] != i) {
                    topSwap = -1;
                    bottomSwap = -1;
                    break;
                }
                // confirmed i is in one of them
                // swap to top
                if (tops[j] != i) {
                    ++topSwap;
                }
                if (bottoms[j] != i) {
                    ++bottomSwap;
                }
            }
            // confirmed the i can be put on top or bottom
            if (topSwap > -1 && bottomSwap > -1)
                minSwap = Math.min(topSwap, bottomSwap);
        }
        return minSwap;
    }

    public static void main(String[] args) {
        LC1007 solution = new LC1007();

    }
}
