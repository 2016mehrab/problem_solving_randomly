import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LC1502 {

    public boolean canMakeArithmeticProgression(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        double d = (max - min)*1.0 / (arr.length - 1);
        if ((int) d != d) {
            return false;
        }
        Set<Integer> set = IntStream.of(arr).boxed().collect(Collectors.toSet());
        int tmp = min;
        for (int i = 0; i < arr.length-1; ++i) {
            if (!set.contains(tmp + (int) d)) {
                return false;
            }
            tmp = tmp + (int) d;
        }

        return true;
    }

    public static void main(String[] args) {

        LC1502 s = new LC1502();
        int[] n = { 0, 0, 1 };
        System.out.println(s.canMakeArithmeticProgression(n));
        ;
    }

}
