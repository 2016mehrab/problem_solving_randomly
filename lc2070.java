import java.util.Arrays;

class LC2070 {
    static int search(int[][] arr, int target) {
        int l = 0;
        int p = -1;
        int r = arr.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid][0] <= target) {
                p = mid;
                l = mid + 1;
            } 
             else {
                r= mid - 1;
            }
        }
        if(p==-1){
            return 0;
        }
        return arr[p][1];
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] result = new int[queries.length];
        Arrays.sort(items, (f, l) -> {
            if (f[0] > l[0]) {
                return 1;
            } else
                return -1;
        });
        int maxBeauty = items[0][1];
        for (int[] i : items) {
            if (maxBeauty < i[1]) {
                maxBeauty = i[1];
            } else if (maxBeauty > i[1]) {
                i[1] = maxBeauty;
            }
        }
        for (int i = 0; i < queries.length; ++i) {
            result[i] = search(items, queries[i]);
        }
        for (int i : result) {
            System.out.println(i);
        }

        return result;
    }

    public static void main(String[] args) {
        LC2070 s = new LC2070();

        int[][] arr = { { 1, 2 }, { 3, 2 }, { 2, 4 }, { 5, 6 }, { 3, 5 } };
        int[] q = { 1, 2, 3, 4, 5, 6 };

        s.maximumBeauty(arr, q);

    }
}
