import java.util.HashMap;
import java.util.Map;

class LC1079 {
    private int numTilePossibilitiesImpl(int[] tileMap) {
        int r = 0;
        for (int i = 0; i < 26; ++i) {
            // already taken in this branch
            if (tileMap[i] == 0)
                continue;
            // take
            ++r;
            // used
            --tileMap[i];
            // explore
            r += numTilePossibilitiesImpl(tileMap);
            // unused
            ++tileMap[i];
        }
        return r;
    }

    public int numTilePossibilities(String tiles) {
        int[] tileMap = new int[26];
        for (int i = 0; i < tiles.length(); ++i) {
            int idx = tiles.charAt(i) - 'A';
            ++tileMap[idx];
        }
        int r = numTilePossibilitiesImpl(tileMap);
        System.out.println(r);
        return r;

    }

    public static void main(String[] args) {
        LC1079 solution = new LC1079();
        solution.numTilePossibilities("AAB");

    }
}
