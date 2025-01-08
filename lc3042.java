class LC3042 {
    public int countPrefixSuffixPairs(String[] words) {
        int N = words.length;
        int r=0;
        for(int i=0; i < N ;++i){
            for(int j = i+1; j < N ;++j){
                if(words[i] .length() > words[j] .length()) continue;
                if(words[j] .startsWith(words[i]) && words[j]. endsWith(words[i]))  ++r;
            }
        }
        return r;
        
    }

    public static void main(String[] args) {
        LC3042 solution = new LC3042();
        
    }
}
