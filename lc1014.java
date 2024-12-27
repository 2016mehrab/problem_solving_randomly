class LC1014 {
    private int score(int index1, int index2, int[]vals){
        return vals[index1]+vals[index2]+index1-index2;
    }
    public int maxScoreSightseeingPair(int[] values) {
        int r=-1;
        int currMax=values[0];
        int immediatePrev=-1;
        for(int curr=1 ; curr<values.length; ++curr){
            currMax -= 1;
            immediatePrev=values[curr-1]-1;
            currMax = immediatePrev > currMax? immediatePrev : currMax;
            int tmp = currMax+ values[curr];
            r= r> tmp? r: tmp;
        }
        
        System.out.println(r);
        return r;
    }

    public int maxScoreSightseeingPairBF(int[] values) {
        int r=-1;
        for(int curr=0 ; curr<values.length; ++curr){
            for(int comp= curr+1; comp<values.length; ++comp){
                int tmp = score (curr, comp, values);
                r= tmp> r? tmp : r;
            }
        }
        
        System.out.println(r);
        return r;
    }

    public static void main(String[] args) {
        LC1014 solution = new LC1014();
        int[] v1={ 8,1,5,2,6 };
        int[]v2= { 1,2 }; 
        solution.maxScoreSightseeingPair(v1);
        solution.maxScoreSightseeingPair(v2);
        
    }
}
