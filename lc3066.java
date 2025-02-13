import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class LC3066 {
    public int minOperations(int[] nums, int k) {
        int r = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>(Arrays.stream(nums).mapToLong(n -> (long) n).boxed().toList());
        while (!pq.isEmpty()) {
            long n1 = pq.poll();
            if (n1 >= k)
                return r;
            long n2 = pq.poll();
            long n3 = n1 * 2 + n2;
            pq.add(n3);
            ++r;
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        LC3066 solution = new LC3066();
        try (Scanner sq = new Scanner(new File("input.txt"))) {
            while (sq.hasNextLine()) {
                // [2,11,10,1,3] 10
                String[] parts = sq.nextLine().split("] ");
                String[] numstr = parts[0].replace("[", "").split(",");
                int[] numarr = Arrays.stream(numstr).mapToInt(Integer::parseInt).toArray();
                int num = Integer.parseInt(parts[1]);
                System.out.println(solution.minOperations(numarr, num));
            }

        }

    }
}
