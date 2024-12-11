import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class LC2981 {
    public int maximumLengthExtremeBruteForce(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s.length(); ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    sb.append(s.charAt(i));
                    if (!map.containsKey(sb.toString())) {
                        map.put(sb.toString(), 0);
                    }
                    map.put(sb.toString(), map.get(sb.toString()) + 1);
                } else
                    break;
            }
        }
        map = map.entrySet().stream().filter(entry -> entry.getValue() >= 3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        int r = -1;
        for (String key : map.keySet()) {
            r = key.length() > r ? key.length() : r;
        }
        System.out.println(map);
        System.out.println("r " + r);
        return r;
    }

    public int maximumLength(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s.length(); ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    sb.append(s.charAt(i));
                    String key = s.charAt(i) + "-" + sb.length();
                    if (!map.containsKey(key)) {
                        map.put(key, 0);
                    }
                    map.put(key, map.get(key) + 1);
                } else
                    break;
            }
        }
        map = map.entrySet().stream().filter(entry -> entry.getValue() >= 3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        int r = -1;
        for (String key : map.keySet()) {
            int len = Integer.parseInt(key.split("-")[1]);
            r = r > len ? r : len;
        }
        System.out.println(map);
        System.out.println("r " + r);
        return r;
    }

    public static void main(String[] args) {
        LC2981 solution = new LC2981();
        solution.maximumLength("aaaa");
        solution.maximumLength("abcaba");
        solution.maximumLength("abcdef");

    }
}
