import java.util.HashSet;
import java.util.Set;

class LC1346 {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; ++i) {
            if (i == 0) {
                set.add(arr[i]);
                continue;
            }
            if (set.contains(arr[i] * 2) ||(arr[i]%2==0 && set.contains(arr[i] / 2)  ) ) {
                return true;
            }
            set.add(arr[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        LC1346 solution = new LC1346();
        int[] arr1 = { 10, 2, 5, 3 };
        int[] arr2 = { 3, 1, 7, 11 };
        int[] arr3 = { 3, -1, 7, -2 };
        System.out.println(solution.checkIfExist(arr1));
        System.out.println(solution.checkIfExist(arr2));
        System.out.println(solution.checkIfExist(arr3));

    }
}
