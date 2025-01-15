class LC2429 {
    public int minimizeXor(int num1, int num2) {
        int x = num1;
        int requiredSetBit = Integer.bitCount(num2);
        int currSetBit = Integer.bitCount(num1);
        int bit = 0;
        if (currSetBit < requiredSetBit) {
            while (currSetBit < requiredSetBit) {
                if (!isSet(x, bit)) {
                    x = setBit(x, bit);
                    ++currSetBit;
                }
                ++bit;
            }
        } else if (currSetBit > requiredSetBit) {

            while (currSetBit > requiredSetBit) {
                if (isSet(x, bit)) {
                    x = unsetBit(x, bit);
                    --currSetBit;
                }
                ++bit;
            }

        }
        return x;
    }

    private boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }

    private int setBit(int x, int bit) {
        return x | (1 << bit);
    }

    private int unsetBit(int x, int bit) {
        return x & (~(1 << bit));
    }

    public static void main(String[] args) {
        LC2429 solution = new LC2429();
        solution.minimizeXor(3, 5);
        solution.minimizeXor(1, 12);

    }
}
