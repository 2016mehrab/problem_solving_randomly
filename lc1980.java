import java.util.HashSet;
import java.util.Set;

class LC1980 {
    private String findDifferentBinaryStringImpl(int position, StringBuilder sb, Set<String> set) {
        if (position == set.size()) {
            if (set.contains(sb.toString())) {
                return "";
            } else
                return sb.toString();
        }
        for (char ch : new char[] { '0', '1' }) {
            sb.append(ch);
            String r = findDifferentBinaryStringImpl(position + 1, sb, set);
            if (!r.equals(""))
                return r;
            sb.deleteCharAt(position);
        }
        return "";

    }

    public String findDifferentBinaryStringBT(String[] nums) {
        Set<String> set = new HashSet<>();
        for (String i : nums)
            set.add(i);
        StringBuilder sb = new StringBuilder();
        String r = findDifferentBinaryStringImpl(0, sb, set);
        System.out.println(r);
        return r;
    }

    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            ans.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        LC1980 solution = new LC1980();
        solution.findDifferentBinaryString(new String[] { "01", "10" });
        solution.findDifferentBinaryString(new String[] { "00", "01" });
        solution.findDifferentBinaryString(new String[] { "111", "011", "001" });

    }
}
