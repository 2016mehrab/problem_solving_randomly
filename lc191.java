class LC191 {
    public int hammingWeight(int n) {
        int count=0;
        while(n>0){

            if((n & 1)==1 ){
                ++count;
            }
            n=n>>1;
        }
        System.out.println(count);
        return count;
    }
    public static void main(String[] args) {
        LC191 s = new LC191();
        s.hammingWeight(2147483645);
        
    }

}
