import java.util.HashMap;
import java.util.Map;

class LC3335 {
    public int lengthAfterTransformations(String s, int t) {
        int MOD = 1000000007;
        long [] freq= new long[26];
        for (char ch:s.toCharArray()){
            ++freq[ch-'a'];
        }
        int res=0;
        long[] tmp=freq.clone();
        for(int i=0; i<t; ++i){
             tmp=freq.clone();
            for(int j=0; j<26; ++j){
                if(freq[j]>0 && j<25){
                    freq[j]%=MOD;
                    tmp[j]=(tmp[j] -freq[j] + MOD)%MOD ;
                    tmp[j+1]= (tmp[j+1] +freq[j] )%MOD ;
                    continue;
                }
                // z
                if(freq[j]>0){
                    freq[j]%=MOD;
                    tmp[0]= (tmp[0]+ freq[j])%MOD;
                    tmp[1]= (tmp[1]+ freq[j])%MOD;
                    tmp[j]=(tmp[j] -freq[j] + MOD)%MOD ;
                }
            }
            freq=tmp;
        }
        for (var i:tmp ) res=(int) (res + i)%MOD;
        System.out.println(res);
        return res;
    }
    public static void main(String[] args) {
        LC3335 solution = new LC3335();
        solution.lengthAfterTransformations("abcyy", 2);
        solution.lengthAfterTransformations("azbk", 2);
        solution.lengthAfterTransformations("cu", 5);
        solution.lengthAfterTransformations("jqktcurgdvlibczdsvnsg",7517 );
    }
}
