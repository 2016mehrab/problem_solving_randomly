import java.util.HashSet;
import java.util.Set;

class LC2570 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i = 0, j = 0;
        int k = 0;
        Set<Integer> set = new HashSet<>();
        for (var n : nums1)
            set.add(n[0]);
        for (var n : nums2)
            set.add(n[0]);

        int[][] r = new int[set.size()][2];
        while (i < nums1.length && j < nums2.length) {
            // compare
            if (nums1[i][0] == nums2[j][0]) {
                // id
                r[k][0] = nums1[i][0];
                // val
                r[k++][1] = nums1[i][1] + nums2[j][1];
                ++i;
                ++j;
            } else if (nums1[i][0] < nums2[j][0]) {
                r[k][0] = nums1[i][0];
                r[k++][1] = nums1[i][1];
                ++i;
            } else {
                r[k][0] = nums2[j][0];
                r[k++][1] = nums2[j][1];
                ++j;
            }
        }
        while (i >= nums1.length && j != nums2.length) {
            r[k][0] = nums2[j][0];
            r[k++][1] = nums2[j][1];
            ++j;
        }
        while (j >= nums2.length && i != nums1.length) {
            r[k][0] = nums1[i][0];
            r[k++][1] = nums1[i][1];
            ++i;
        }
        prettyPrint(r);
        return r;

    }

    public static void prettyPrint(int[][] arr) {
        System.out.println("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("  [");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                if (j < arr[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            if (i < arr.length - 1) {
                System.out.println(",");
            } else {
                System.out.println();
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        LC2570 solution = new LC2570();
        solution.mergeArrays(new int[][] { { 1, 2 }, { 2, 3 }, { 4, 5 } },
                new int[][] { { 1, 4 }, { 3, 2 }, { 4, 1 } });
        solution.mergeArrays(new int[][] { { 2, 4 }, { 3, 6 }, { 5, 5 } }, new int[][] { { 1, 3 }, { 4, 3 } });

    }
}
