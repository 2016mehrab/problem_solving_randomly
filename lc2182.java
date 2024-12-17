import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class LC2182 {
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<Character> maxheap = new PriorityQueue<>((f, l) -> Character.compare(l, f));
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (!freq.containsKey(ch)) {
                freq.put(ch, 0);
            }
            freq.put(ch, freq.get(ch) + 1);
        }
        for (char ch : freq.keySet())
            maxheap.add(ch);

        while (!maxheap.isEmpty()) {
            char curr = maxheap.poll();
            int use = freq.get(curr) > repeatLimit ? repeatLimit : freq.get(curr);
            for (int i = 0; i < use; ++i)
                sb.append(curr);
            int remaining_use = freq.get(curr) - use;
            if (remaining_use > 0 && !maxheap.isEmpty()) {
                char nextcurr = maxheap.poll();
                sb.append(nextcurr);
                freq.put(nextcurr, freq.get(nextcurr) - 1);
                if (freq.get(nextcurr) > 0) {
                    maxheap.add(nextcurr);
                }
                freq.put(curr, remaining_use);
                maxheap.add(curr);
            }

        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void opt() {
        String s = "abc";
        byte[] r;
        int[] freq = new int[26];
        for (byte ch : (r = s.getBytes(java.nio.charset.StandardCharsets.US_ASCII))) {
            ++freq[ch - 97];
        }
        System.out.println(new String(r));
    }

    public static void main(String[] args) {
        LC2182 solution = new LC2182();
        opt();
        solution.repeatLimitedString("cczazcc", 3);
        solution.repeatLimitedString("aababab", 2);

    }
}
