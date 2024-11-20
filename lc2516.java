class LC2516 {
    public boolean isValid(int[] map, int requirement) {
        for (int i : map) {
            if (i < requirement) {
                return false;
            }
        }
        return true;
    }

    public int takeCharacters(String s, int k) {
        int[] map = new int[3];
        int N = s.length();
        for (int i = 0; i < N; ++i) {
            int index = s.charAt(i) - 'a';
            map[index] += 1;
        }
        for (int i : map) {
            if (i < k) {
                return -1;
            }
        }
        int left = 0;
        int minutes = Integer.MAX_VALUE;
        for (int right = 0; right < N; ++right) {
            int index = s.charAt(right) - 'a';
            // take
            map[index] -= 1;

            while (left < N && !isValid(map, k)) {
                index = s.charAt(left) - 'a';
                map[index] += 1;
                ++left;
            }
            minutes = Math.min(minutes, N - (right - left + 1));

        }
        return minutes == Integer.MAX_VALUE ? -1 : minutes;

    }

    public static void main(String[] args) {
        LC2516 s = new LC2516();
        System.out.println(s.takeCharacters("abc", 1));
        System.out.println(s.takeCharacters("aabaaaacaabc", 2));
        System.out.println(s.takeCharacters("a", 1));
        ;

    }

}
