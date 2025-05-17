import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class LC2901 {
    private static int hamDist(String s, String t) {
        if (s.length() != t.length())
            return -1;
        int cnt = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != t.charAt(i))
                cnt++;
        }
        return cnt;

    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int N = words.length;
        List<String> res = new ArrayList<>();
        int[] subseqcnt = new int[N];
        int[] parent = new int[N];
        for (int i = 0; i < N; ++i) {
            subseqcnt[i] = 1;
            parent[i] = -1;
        }
        int maxLen = 1;
        int maxLenIdx = 0;
        for (int curr = 0; curr < N; ++curr) {
            for (int j = 0; j < curr; ++j) {
                if (hamDist(words[j], words[curr]) == 1 && groups[curr] != groups[j]
                        && subseqcnt[j] + 1 > subseqcnt[curr]) {
                    subseqcnt[curr] = subseqcnt[j] + 1;
                    if (subseqcnt[curr] > maxLen) {
                        maxLen = subseqcnt[curr];
                        maxLenIdx = curr;
                    }

                    parent[curr] = j;
                }
            }
        }
        int k = maxLenIdx;
        Stack<String> r = new Stack<>();
        while (k > -1) {
            r.add(words[k]);
            k = parent[k];

        }
        while (!r.isEmpty()) {
            res.add(r.pop());
        }

        System.out.println(res);

        return res;

    }

    static void pprint(Object arr) {
        System.out.println();
        if (arr instanceof int[]) {
            int[] intArray = (int[]) arr;
            for (int i = 0; i < intArray.length; ++i) {
                System.out.print(intArray[i] + ", ");
            }
        } else if (arr instanceof String[]) {
            String[] stringArray = (String[]) arr;
            for (int i = 0; i < stringArray.length; ++i) {
                System.out.print(stringArray[i] + ", ");
            }
        } else {
            System.out.println("Unsupported array type");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LC2901 solution = new LC2901();
        Scanner sc = new Scanner(System.in);

        int sig = 0;
        while (sig != -1) {
            System.out.println("Enter n: ");
            int n = sc.nextInt();
            System.out.println("Enter words:");
            String[] words = new String[n];
            for (int i = 0; i < n; ++i)
                words[i] = sc.next();
            System.out.println("Enter groups:");
            int[] groups = new int[n];
            for (int i = 0; i < n; ++i)
                groups[i] = sc.nextInt();
            System.out.println("Inputs:");
            pprint(groups);
            pprint(words);
            System.out.println("Ouput: " + solution.getWordsInLongestSubsequence(words, groups));

        }
        sc.close();

    }
}
