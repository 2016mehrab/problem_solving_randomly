import java.util.Collections;
import java.util.PriorityQueue;

class LC2558 {
    public long pickGifts(int[] gifts, int k) {
        long originalSum = 0;
        long giftsTaken = 0;
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        for (int g : gifts)
            maxheap.add(g);
        for (int i = 0; i < gifts.length; ++i)
            originalSum += gifts[i];

        for (int i = 0; i < k; ++i) {
            int tmp = maxheap.poll();
            int rem = (int) Math.floor(Math.sqrt(tmp));
            giftsTaken += tmp - rem;
            maxheap.add(rem);
        }
        return originalSum - giftsTaken;

    }

    public static void main(String[] args) {
        LC2558 solution = new LC2558();
        int[] g1 = { 25, 64, 9, 4, 100 };
        int[] g2 = { 1, 1, 1, 1 };
        solution.pickGifts(g1, 4);
        solution.pickGifts(g2, 4);

    }
}
