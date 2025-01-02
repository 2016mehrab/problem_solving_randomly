class LC2559 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int N= words.length;
        int []prefix= new int[N+1];
        int [] map = new int[26];
        map[0] = 1;
        map['e'-'a'] = 1;
        map['i'-'a'] = 1;
        map['o'-'a'] = 1;
        map['u'-'a'] = 1;
        for(int i=0; i< N ;++i ){
            if((map[words[i].charAt(0) - 'a'] ==1 ) && (map[words[i].charAt(words[i].length()-1) - 'a'] ==1)){
                prefix[i+1] = prefix[i]+1;
            }
            else{
                prefix[i+1] = prefix[i];
            }
        }
        int j=0;
        int []r = new int[queries.length];
        for(int [] query : queries){
            r[j++] = prefix[query[1] + 1]- prefix[query[0]];

        }
        return r;
    }
    public static void main(String[] args) {
        LC2559 solution = new LC2559();
        String[] w1={ "aba","bcb","ece","aa","e" };
        int[][]q1= { { 0,2 },{ 1,4 },{ 1,1 } };
        String [] w2={ "a","e","i" };
        int[][]q2={ { 0,2 },{ 0,1 },{ 2,2 } };
        solution.vowelStrings(w1, q1);
        solution.vowelStrings(w2, q2);

    }
}
