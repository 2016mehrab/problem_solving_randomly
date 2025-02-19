import java.util.ArrayList;
import java.util.List;

class LC1415 {
    private void getHappyStringImpl(StringBuilder sb, int position, List<String> result, char[] letters, int n, int k) {
        if (result.size() == k)
            return;
        if (position == n) {
            result.add(sb.toString());
            return;
        }
        for (char i : letters) {
            if (position > 0 && sb.charAt(position - 1) == i)
                continue;
            // take
            sb.append(i);
            // explore
            getHappyStringImpl(sb, position + 1, result, letters, n, k);
            // undo
            sb.deleteCharAt(position);

        }
        return;

    }

    public String getHappyString(int n, int k) {
        List<String> result = new ArrayList<>();
        char[] letters = { 'a', 'b', 'c' };
        StringBuilder sb = new StringBuilder();
        getHappyStringImpl(sb, 0, result, letters, n, k);
        System.out.println(result);
        if (result.size() < k)
            return "";
        System.out.println(result.get(k - 1));
        return result.get(k - 1);

    }

    public static void main(String[] args) {
        LC1415 solution = new LC1415();
        solution.getHappyString(1, 3);
        solution.getHappyString(1, 4);
        solution.getHappyString(3, 9);

    }
}
