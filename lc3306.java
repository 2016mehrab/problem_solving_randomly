class LC3306 {
    private boolean isVowel(char ch){

        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public long countOfSubstrings(String word, int k) {
        long numValidSubStrings =0;
        Map<Character, Integer> vowelCount = new HashMap<>();
        int consonantCount = 0;
        int [] nextConsonant = new int[word.length()];
        int nextConsonantIndex = word.length();
        for(int i = word.length() -1; i>=0; --i){
            nextConsonant[i] =nextConsonantIndex;
 if (!isVowel(word.charAt(i))) {
                nextConsonantIndex = i;
            }
        }
 int start = 0;
        int end = 0;
 while (end < word.length()) {
            // insert new letter
            char newLetter = word.charAt(end);

            // update counts
            if (isVowel(newLetter)) {
                vowelCount.put(
                    newLetter,
                    vowelCount.getOrDefault(newLetter, 0) + 1
                );
            } else {
                consonantCount++;
            }

            // shrink window if too many consonants in our window
            while (consonantCount > k) {
                char startLetter = word.charAt(start);
                if (isVowel(startLetter)) {
                    vowelCount.put(
                        startLetter,
                        vowelCount.get(startLetter) - 1
                    );
                    if (vowelCount.get(startLetter) == 0) {
                        vowelCount.remove(startLetter);
                    }
                } else {
                    consonantCount--;
                }
                start++;
            }

            // while we have a valid window, try to shrink it
            while (
                start < word.length() &&
                vowelCount.keySet().size() == 5 &&
                consonantCount == k
            ) {
                // count the current valid substring, as well as valid substrings produced by appending more vowels
                numValidSubstrings += nextConsonant[end] - end;
                char startLetter = word.charAt(start);
                if (isVowel(startLetter)) {
                    vowelCount.put(
                        startLetter,
                        vowelCount.get(startLetter) - 1
                    );
                    if (vowelCount.get(startLetter) == 0) {
                        vowelCount.remove(startLetter);
                    }
                } else {
                    consonantCount--;
                }

                start++;
            }
            end++;
        }

        return numValidSubstrings;
        
    }

    public static void main(String[] args) {

        LC3306 solution = new LC3306();
        
    }
}
