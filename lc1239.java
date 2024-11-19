import java.util.Arrays;
import java.util.List;

class LC1239 {
    public Boolean hasDuplicate(String a, String b){
        int[] map =new int[26];
        for(int i=0; i<a.length();++i){
            int index = a.charAt(i)-'a';
            if(map[index]>0){
                return true;
            }
            map[index]=1;
        }
        for(int i=0; i<b.length();++i){
            int index = b.charAt(i)-'a';
            if(map[index]>0){
                return true;
            }
            map[index]=1;
        }

        return false;
    }

    public int solve(int index,  String tmp, List<String > arr){
        if(index >= arr.size()) return tmp.length();
        int take=0;
        int skip=0;
        skip = solve(index+1, tmp , arr );
        if(!hasDuplicate(tmp, arr.get(index))){
            take = solve(index+1, tmp+arr.get(index), arr);
        }
        return Math.max(take, skip);

    }
    public int maxLength(List<String> arr) {
        
        return solve(0,"",arr );
        
    }
    public static void main(String[] args) {
        List<String> a = Arrays.asList("un", "iq", "ue");
        LC1239 s = new LC1239();
        System.out.println(s.maxLength(a));
        ;
        
    }
    
}
