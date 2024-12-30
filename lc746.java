class LC746 {
    private int solve(int idx ,int[] cost, int[] cache){
        if(idx>=cost.length) return 0;
        if(cache[idx]!=-1) return cache[idx];
        int smallStep =cost[idx] + solve(idx+1, cost, cache);
        int bigStep =cost[idx]+ solve(idx+2, cost, cache);
        cache[idx] = Math.min(smallStep, bigStep);
        return cache[idx];
    }

    public int minCostClimbingStairs(int[] cost) {
        int N =cost.length;
        int []cache = new int [N+1];
        for (int i = 0; i < N+1; i++) {
            cache[i]=-1;
        }
        int r = solve(0, cost ,cache);
        int p = solve(1, cost ,cache);
        System.out.println(Math.min(r,p));
        return Math.min(r,p);
        
    }

    public static void main(String[] args) {
        LC746 solution = new LC746();
        int[]c1= { 10,15,20 };
        int[]c2= { 1,100,1,1,1,100,1,1,100,1 };
        solution.minCostClimbingStairs(c1);
        solution.minCostClimbingStairs(c2);
    }
}
