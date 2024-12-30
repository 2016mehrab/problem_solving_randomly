class LC2466 {

    int MOD=1000000007;
    private int solve ( int len , int low ,int high, int zero, int one ,int[]cache){
        if(len> high) return 0;
        if(cache[len] !=-1){
            return cache[len];
        }

        if(len >= low) {
            cache[len]=(1 + solve (len+zero, low ,high, zero, one, cache) + solve(len+one, low ,high, zero ,one, cache))%MOD;
        }
        else cache[len] =(solve (len+zero, low ,high, zero, one,cache) + solve(len+one, low ,high, zero ,one ,cache))%MOD; 
        return cache[len];
    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        int []cache = new int [high +1];
        for (int i = 0; i < high+1; i++) {
            cache[i] = -1;
        }
        int r = solve (0, low, high, zero, one, cache);
        System.out.println(r);
        return r;
        
    }
    public static void main(String[] args) {
        LC2466 solution = new LC2466();
        solution.countGoodStrings(3, 3, 1, 1);
        solution.countGoodStrings(2, 3, 1, 2);
        
    }
}
