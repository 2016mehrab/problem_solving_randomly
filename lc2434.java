import java.util.Stack;

class LC2434 {
    boolean isSmallest(StringBuilder ss, int chIdx) {
        for (int i = chIdx + 1; i < ss.length(); ++i) {
            if (ss.charAt(i) >= ss.charAt(chIdx))
                continue;
            return false;

        }
        return true;
    }

    public String robotWithString(String s) {
        int N = s.length();
        char[] smallest = new char[N];
        for (int i = N - 1; i > -1; --i) {
            if (i == N - 1) {
                smallest[i] = s.charAt(i);
                continue;
            }
            if (s.charAt(i) <= smallest[i + 1])
                smallest[i] = s.charAt(i);
            else
                smallest[i] = smallest[i + 1];
        }

        StringBuilder ss = new StringBuilder(s);
        Stack<Character> st = new Stack<>();
        StringBuilder paperBuilder = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            // first character should always move to t
            st.push(ss.charAt(i));

            char minCh = (i + 1 < N) ? smallest[i + 1] : ss.charAt(i);
            // b smallest? move to paper
            while (!st.isEmpty() && minCh >= st.peek()) {

                paperBuilder.append(st.pop());

            }

            ++i;
        }
        // add the rest
        while (!st.isEmpty()) {
            paperBuilder.append(st.pop());
        }

        System.out.println(paperBuilder.toString());
        return paperBuilder.toString();
    }

    public static void main(String[] args) {
        LC2434 solution = new LC2434();
        solution.robotWithString("zza");
        solution.robotWithString("bac");
        solution.robotWithString("bdda");

    }
}
