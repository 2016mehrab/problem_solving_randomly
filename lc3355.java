class LC3355 {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int N = nums.length;
        int [] diffArr = new int[N];
        for(var query : queries){
            diffArr[query[0]]-=1;
            if(query[1] < N-1){
                diffArr[query[1]+1]+=1;
            }
        }
        for(int i =1 ;i< N;++i){
            diffArr[i]+= diffArr[i-1];
        }
        for (int i =0 ;i< N;++i){
            nums[i]=Math.max(0,diffArr[i]+nums[i]);
            if(nums[i]>0) return false;

        }
        return true;
    }
    public static void main(String[] args) {
        LC3355 solution = new LC3355();
        solution.isZeroArray(new int[]{ 1,0,1 }, new int[][]{{ 0,2 }});
        solution.isZeroArray(new int[]{4,3,2,1}, new int[][]{ { 1,3 },{ 0,2 } });
        
    }
}
