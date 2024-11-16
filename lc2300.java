import java.util.Arrays;

class LC2300 {
    static int lowerBound(int spell, long success, int[] potions) {
        int l = 0;
        int r = potions.length - 1;
        int mid;
        int result = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if ((long)potions[mid] * spell >= success) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return result;

    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];
        int index = 0;
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; ++i) {
            int tmp = lowerBound(spells[i], success, potions);
            pairs[index++] = tmp == -1 ? 0 : potions.length - tmp;
        }


        return pairs;

    }

    public static void main(String[] args) {
        LC2300 s = new LC2300();
        int[] spells = { 5, 1, 3 };
        int[] potions = { 1, 2, 3, 4, 5 };
        s.successfulPairs(spells, potions, 7);
    }

}
