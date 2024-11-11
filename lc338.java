import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class LC338 {
    public int[] countBits(int n) {
        int[] r = new int[n + 1];
        if (n+1 > 1) {
            r[1] = 1;

        }
        for (int i = 2; i < n + 1; ++i) {
            double tmp = Math.log(i) / Math.log(2);
            boolean hasNoFraction = (int) tmp == tmp;
            if (hasNoFraction) {
                r[i] = 1;
                continue;
            }
            if (i % 2 != 0) {

                r[i] = r[(i / 2)] + 1;
            } else {
                r[i] = r[(i / 2)];

            }
        }
        return r;

    }

    public static void main(String[] args) {
        LC338 s = new LC338();
        int[] arr = s.countBits(1);
        // boxed for wrapping int with Integer
        List<Integer> arrayList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(arrayList);
    }

}