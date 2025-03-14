import java.util.Arrays;

class LC2226 {
    private boolean isPossible(int n, int[] candies, long kids){
        long s=0;
        if(n==0) return true;
        for(int i: candies){
            s += i/n;
        }
        if(s >= kids) return true;
        return false;
    }

    public int maximumCandies(int[] candies, long k) {
        int res=0;
        int N=candies.length;
        int l=0;
        int r=-1;
        for(int i: candies) r=Math.max(r,i);
        while(l<=r){
            int mid = (l+r)/2;
            if(isPossible(mid, candies, k)){
                res = mid;
                l= mid+1;
            }
            else r=mid -1;
        }
        
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        LC2226 solution = new LC2226();
        solution.maximumCandies(new int[]{11}, 11);
        solution.maximumCandies(new int[]{5,8,6},3);
        solution.maximumCandies(new int[]{2,5},11);
        solution.maximumCandies(new int[]{4,7, 5},4);
        solution.maximumCandies(new int[]{5,6,4,10,10,1,1,2,2,2} ,9);
        

    }
}
