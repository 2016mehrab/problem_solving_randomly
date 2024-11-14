class LC2187 {
    static long direction(long m, int totalTrips,int[]time){
        long r=0;
        for (int i : time) {
            r+=m/i;
        }
        if(r==totalTrips) return 0;
        if(r<totalTrips) return -1;
        return 1;

    }
    public long minimumTime(int[] time, int totalTrips) {
        long l=1;
        long r=Integer.MAX_VALUE;
        for (int i : time) {
            if(i<r){
                r=i;
            }
        }
        r*=totalTrips;
        long mid;
        long result=-1;
        while (l<=r) {
            mid=l+(r-l)/2;
            if(direction(mid, totalTrips, time)>=0){
                r=mid-1;
                result=mid;
            }
            else{
                l=mid+1;
            }
            
        }
        return result;
        
    }
    public static void main(String[] args) {
        
        LC2187 s = new LC2187();
        int [] time={1,2,3};
        int [] time1={2};
        s.minimumTime(time1,1);
    }
    
}
