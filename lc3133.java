class LC3133 {
    public long minEnd(int n, int x) {
        long num=x-1;
        for(int i=0; i<n; i++){
            ++num;
            if((num & x)!=x){
                num= num | x;
            }
        }

        return num;
    }
    public static void main(String[] args) {
       LC3133 s = new LC3133(); 
       System.out.println(s.minEnd(3, 4));
       System.out.println(s.minEnd(2, 7));
       System.out.println(s.minEnd(6715154, 7193485));
    }

}
