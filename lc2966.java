class LC2966 {
    public int[][] divideArray(int[] nums, int k) {
        int N = nums.length; 
        int [][] res = new int[N/3][3];
    // sorting will give the optimal ans
        // if adjacent num breaks constraint and we can form a valid group ,
        // then obviously, grouping up with distant num would also be invalid
        Arrays.sort(nums);
        int [] tmp = new int[3];
        int j=0;
        int min=nums[0];
        for(int i=0; i< N; ++i){
            // time to add tmp to res and reset tmp
            if(i!=0 && i%3==0){
                res[j++]=tmp.clone();
                Arrays.fill(tmp,0);
                min = nums[i];
            }
            if(nums[i] - min <=k){
                tmp[i%3] = nums[i];
            }
            else return new int[0][0];

        }

                res[j++]=tmp.clone();
        return res;
    
    }

    public static void main(String[] args) {
        LC2966 solution = new LC2966();
        
    }
}
