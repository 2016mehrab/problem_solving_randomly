import java.util.Arrays;

class LC1639 {
    int MOD= 1000000007;
    public int numWays(String[] words, String target) {
        int WL= words[0].length();
        int TL=target.length();
        int [][]charFreq= new int[WL][26];
        int[][] dp = new int[WL][TL];
        for (int i = 0; i < WL; i++) {
            Arrays.fill(dp[i], -1);
        }
        for(String w: words){
            for(int c=0; c<WL; ++c){
                ++charFreq[c][w.charAt(c)-'a'];
            }
        }
        int r =(int) getWords(words, target, 0, 0, dp, charFreq);
        System.out.println(r);
        return r;
    }
    private long getWords(
        String[] words,
        String target,
        int wordsPos,
        int targetIndex,
        int[][] dp,
        int[][] charFrequency
    ){
        if(targetIndex>= target.length()) return 1;
        if(wordsPos == words[0].length()|| words[0].length() -wordsPos < target.length()-targetIndex  ) return 0;
        if (dp[wordsPos][targetIndex] != -1) return dp[wordsPos][targetIndex];
        long ways =0;
        int currChar = target.charAt(targetIndex) - 'a';
        // take
        ways+= getWords(words, target ,wordsPos +1, targetIndex+1, dp, charFrequency) * charFrequency[wordsPos][currChar];
        // skip
        ways+= getWords(words, target ,wordsPos +1, targetIndex, dp, charFrequency);
        dp[wordsPos][targetIndex] = (int) (ways % MOD);
        return  dp[wordsPos][targetIndex];

    }
    public static void main(String[] args) {
        LC1639 solution = new LC1639();
        String []s2= { "abba","baab" };
        String [] s1 ={ "acca","bbbb","caca" };
        solution.numWays(s1, "aba");
        solution.numWays(s2, "bab");
    }

}
