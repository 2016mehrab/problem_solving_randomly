class LC2270 {

    public int waysToSplitArray(int[] nums) {
        int r=0;
        long suffix =0;
        long prefix =0;
        for(int i : nums){
            suffix+=i;
        }
        for(int i =0 ;i < nums.length-1; ++i){
            prefix+=nums[i];
            suffix-=nums[i];
            if(prefix >= suffix) ++r;

        }
        System.out.println(r);
        return r;
    }

    public static void main(String[] args) {
        LC2270 solution = new LC2270();
        int []nums1 = { 10,4,-8,7 };
        int[]nums2 = { 2,3,1,0 };
        int[]nums3 = { 6,-1,9 };
        solution.waysToSplitArray(nums1);
        solution.waysToSplitArray(nums2);
        solution.waysToSplitArray(nums3);
        
    }
}
