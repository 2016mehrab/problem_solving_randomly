class LC2433 {
    public int[] findArray(int[] pref) {
        int[] result = new int[pref.length];
        result[0]=pref[0];
        for(int i=1; i<pref.length; ++i){
            result[i]=pref[i-1] ^ pref[i];

        }
        for (int i : result) {
            System.out.println(i);
            
        }
        return result;

    }
    public static void main(String[] args) {
        LC2433  s= new LC2433();
        int[] pref ={5,2,0,3,1};
        s.findArray(pref);
        
    }

}
