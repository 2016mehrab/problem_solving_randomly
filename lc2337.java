class LC2337 {
    public boolean canChange(String start, String target) {
        int N = start.length();
        int i=0;
        int j=0;
        while(i<N || j<N ){
            // if one of the index is exhausted these will
            // make sure to exhaust the other one as well if
            // it is a valid case.
            while(i < N && start.charAt(i)=='_') ++i;
            while(j < N && target.charAt(j)=='_') ++j;
            // if one exhausts
            if(i>=N || j>=N) {
                return i==N && j==N;
            }
            if((start.charAt(i)=='L' && i<j) || start.charAt(i)!=target.charAt(j) || (start.charAt(i)=='R' && i>j)){
return false;
            } 
            ++j;
            ++i;

        }
        return true;
    }
    public static void main(String[] args) {
        LC2337 solution = new LC2337();
        
    }
}
