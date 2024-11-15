class LC1574 {

    public int findLengthOfShortestSubarray(int[] arr) {
        int i = 0;
        int size = arr.length;
        // find the longest nondecreasing
        while (i + 1 < size && arr[i] <= arr[i + 1]) {
            ++i;
        }
        // If the array is already sorted
        if (i == size - 1) {
            return 0;
        }
        int e = size - 1;
        while (e > 0 && arr[e] >= arr[e - 1]) {
            --e;
        }
        int result = Math.min(size - 1 - i, e);
        int right = e;
        int left = 0;
        while (left <= i && right < size) {
            if (arr[left] <= arr[right]) {
                result = Math.min(result, right - left - 1);
                ++left;
            } else
                ++right;
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        LC1574 s = new LC1574();
        int[] arr = { 1, 2, 3, 10, 4, 2, 3, 5 };
        int[] arr1 = { 10, 4, 2, 3, 5 };
        int[] arr2 = { 1, 2, 3, 10, 3, 2, 1, 0 };
        int[] arr3 = { 1, 2, 3, 5 };
        int[] arr4 = { 1, 2, 3, 10, 0, 7, 8, 9 };
        int [] n ={61,19,38,47,38,30,1,16,40,56,25,59,52,1,56,47,36,12,17,56,3,30,39,28,42,41,16,57,33,15,15};
        // s.findLengthOfShortestSubarray(arr);
        // s.findLengthOfShortestSubarray(arr1);
        // s.findLengthOfShortestSubarray(arr2);
        // s.findLengthOfShortestSubarray(arr3);
        // s.findLengthOfShortestSubarray(arr4);
        s.findLengthOfShortestSubarray(n);
    }

}