import java.util.Arrays;

class LC2342 {
    private int sumOfDigits(int num){
        int sum =0;
        while(num > 0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        int [] map = new int[82];
        Arrays.fill(map, -1);
        int r=-1;
        for(int i=0 ; i< nums.length;++i){
            int sumOfDigits = this.sumOfDigits(nums[i]);
            int tmp=map[sumOfDigits];
            if(tmp==-1){
                map[sumOfDigits] = nums[i];
            }
            else{
                r= Math.max(r, tmp+nums[i]);
                map[sumOfDigits] =Math.max(tmp,nums[i]) ;
            }

        }

        System.out.println(r);
        return r;
        
    }

    public static void main(String[] args) {
        LC2342 solution = new LC2342();
        int[]nums = {18,43,36,13, 7};
        solution.maximumSum(nums);
        
    }
}
