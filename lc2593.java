import java.util.PriorityQueue;

class LC2593 {
    public long findScore(int[] nums) {
        int N = nums.length;
        int[] visited = new int[N];
        int visitedSum = 0;
        long sum = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((f, l) -> {
            if(f[0] == l[0]){
                return f[1]-l[1];
            }
            return f[0]-l[0];
        });
        for (int i = 0; i < N; ++i) {
            minHeap.add(new int[] { nums[i], i });
        }
        while (!minHeap.isEmpty() && visitedSum < N) {
            int[] curr = minHeap.poll();
            int v = curr[0];
            int idx = curr[1];
            if (visited[idx] == 1)
                continue;
            sum += v;
            visited[idx] = 1;
            ++visitedSum;
            if (idx > 0 && visited[idx - 1] != 1) {
                visited[idx - 1] = 1;
                ++visitedSum;
            }
            if (idx < N - 1 && visited[idx + 1] != 1) {
                visited[idx + 1] = 1;
                ++visitedSum;
            }

        }
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        LC2593 solution = new LC2593();
        int[] n1 = { 2, 1, 3, 4, 5, 2 };
        int[] n2 = { 2, 3, 5, 1, 3, 2 };
        int[] n3 = { 29, 20, 36, 39, 50, 42, 46, 34, 47 };
        int [] n4={ 2,5,6,6,10 };
        solution.findScore(n1);
        solution.findScore(n2);
        solution.findScore(n3);
        solution.findScore(n4);

    }
}
