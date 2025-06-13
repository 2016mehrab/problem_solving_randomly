class LC3423 {
    public int maxAdjacentDistance(int[] nums) {
        int N =nums.length;
        int r=-200;
        for(int i=0; i< N;++i){
            r = Math.max(r, Math.abs(nums[i]- nums[(i+1)%N]));
        }
        return r;
        
    }

    public static void main(String[] args) {
        LC3423 solution = new LC3423();
        
    }
}
