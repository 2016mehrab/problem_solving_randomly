import java.util.HashMap;
import java.util.Map;

class LC494 {
    Map<String, Integer> dp = new HashMap<>();
    private int solve(int index,int sum ,int target ,int[] nums){
        if(index >= nums.length){
            if(sum == target) return +1;
            else return 0;
        }
        String key = index+"-"+sum;
        if(dp.containsKey(key)) return dp.get(key);
        
        int add = solve (index+1, sum+nums[index], target, nums);
        int subtract = solve(index+1,sum-nums[index] , target, nums);
        dp.put(key,add+subtract);
        return add+subtract;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int ways= solve(0, 0,target, nums);
        System.out.println(ways);
        this.dp.clear();
        return ways;
        
    }
    public static void main(String[] args) {
        LC494 solution = new LC494();

        int[]n1= { 1,1,1,1,1 };
        int[]n2 ={1};
        int [] n3 = { 1,0 };
        solution.findTargetSumWays(n1, 3);
        solution.findTargetSumWays(n2, 1);
        solution.findTargetSumWays(n3, 1);
        
    }
}
