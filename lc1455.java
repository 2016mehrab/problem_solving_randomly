import java.awt.List;
import java.util.Arrays;
import java.util.stream.Stream;

class LC1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {

        String[] words = sentence.split(" ");
        Arrays.stream(words).forEach(System.out::println);
        for(int i=0; i< words.length ;++i){
            if(words[i].length() >= searchWord.length() && words[i].substring(0, searchWord.length()).equals(searchWord)){
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC1455 solution = new LC1455();
        String s1 = "i love eating burger";
        String s2 = "this problem is an easy problem";
        String s3 = "i am tired";
        solution.isPrefixOfWord(s1, "burg");
        solution.isPrefixOfWord(s2, "pro");
        solution.isPrefixOfWord(s3, "you");

    }
}
