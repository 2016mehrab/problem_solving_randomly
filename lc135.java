class LC135 {
    public int candy(int[] ratings) {
        int N= ratings.length;
        // find dependency of left neighbors
        int [] leftDep = new int[N];
        Arrays.fill(leftDep, 1);
        for(int i=1; i<N;++i){
            if(ratings[i]>ratings[i-1]){
                leftDep[i]= leftDep[i-1]+1;
            }
        }
        int [] rightDep = new int[N];
        Arrays.fill(rightDep, 1);

        for(int i=N-2; i>-1;--i){
            if(ratings[i]>ratings[i+1]){
                rightDep[i]= rightDep[i+1]+1;
            }
        }
        int res=0;
        for(int i=0; i<N;++i){
            res = Math.max(leftDep[i], rightDep[i]);
        }
        return res;


    }
    public static void main(String[] args) {
        LC135 solution = new LC135();
    }
}
