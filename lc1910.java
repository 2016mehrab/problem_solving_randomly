import java.util.Stack;

class LC1910 {
    public String removeOccurrences(String s, String part) {
        Stack<Character> stk = new Stack<>();
        int M= s.length();
        int N = part.length();
        for (int i=0 ;i < M; ++i){
            stk.push(s.charAt(i));
            if(stk.size()>=N && isMatch(stk, part, N)){
                for(int j =0;  j < N; ++j){
                    stk.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
    private boolean isMatch(Stack<Character>stk, String part, int partSize){
        if(stk.isEmpty() || part.charAt(partSize-1) != stk.peek()){
            return false;
        }
        Stack<Character> tmp = new Stack<>();
        tmp.addAll(stk);
        for(int i =partSize-1; i > -1; --i){
            if(tmp.isEmpty() || part.charAt(i) != tmp.peek()){
                return false;
            }
            tmp.pop();
        }
        return true;
    }
    public static void main(String[] args) {
        LC1910 solution = new LC1910();
        
    }
}
