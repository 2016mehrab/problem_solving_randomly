class LC2064 {
    static int validDistribution(int target,int n,int [] arr){
        int r,q;
        int tmp=0;
        for (int i : arr) {
            q=i/target;
            r=i%target;
            tmp+=q;
            if(r!=0){
               ++ tmp;
            }
        }
        if(tmp==n) return 0;
        if(tmp<n) return -1;
        return 1;

    }
    public int minimizedMaximum(int n, int[] quantities) {
        int sum=0;
        int max=Integer.MIN_VALUE;
        for (int i : quantities) {
            if(max<i){
                max=i;
            }
            sum+=i;
        }
        int l = (int) Math.ceil((double) 1.0* sum / n);
        int r=max;
        int mid;
        if(validDistribution(l, n, quantities)==0){
            return l;
        }
        while (l<=r) {
            mid=(l+r)/2;
            int direction=validDistribution(mid, n, quantities);
            if(direction<=0){
                sum=mid;
                r=mid-1;
            }
            else {
                l=mid+1;
            }
            
        }

        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {

        LC2064 s = new LC2064();
        int [] arr= {15,10,10};
        int [] arr1= {11,6};
        int [] arr2= {24,18,12,6,3,24,5,19,10,20,2,18,27,3,13,22,11,16,19,13};
        
        s.minimizedMaximum(26,arr2);
        // s.minimizedMaximum(7, arr);
        
    }
    
}
