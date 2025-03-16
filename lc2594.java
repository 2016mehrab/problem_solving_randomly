class LC2594 {
    private boolean canRepair(int[] ranks ,long time ,int cars ){
        int canRepair =0;
        for(int rank : ranks){
            canRepair+= Math.sqrt(time/rank);
        }
        return canRepair >= cars;
    }
    public long repairCars(int[] ranks, int cars) {
       long l=1; 
        long r = -1;
        long res=-1;
        for(int i : ranks) r=Math.max(r, i);
        r*=(long)cars*cars;
        while(l<=r){
            long mid = (l+r)/2;
            if(canRepair(ranks, mid, cars)){
                res =mid;
                r=mid-1;
            }
            else 
            l= mid+1;
        }
        System.out.println(res);
        return res;
    }
    public static void main(String[] args) {
        LC2594 solution = new LC2594();
        solution.repairCars(new int[]{ 31,31,5,19,19,10,31,18,19,3,16,20,4,16,2,25,10,16,23,18,21,23,28,6,7,29,11,11,19,20,24,19,26,12,29,29,1,14,17,26,24,7,11,28,22,14,31,12,3,19,16,26,11 },736185 );
        
    }
}
