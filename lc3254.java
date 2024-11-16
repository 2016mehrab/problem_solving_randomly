class LC3254 {
    public int[] resultsArray(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int count = 1;
        int l = 0;
        int r = l + k - 1;
        int index = 0;
        while (l < nums.length && r <= nums.length - 1) {
            if (l == 0) {
                int tmp = 0;
                while (tmp < k - 1) {
                    if (nums[tmp] + 1 == nums[tmp + 1]) {
                        ++count;
                    } else {
                        count = 1;
                    }
                    ++tmp;
                }
                if (count == k) {
                    result[index++] = nums[l + k - 1];
                } else {
                    result[index++] = -1;
                }
                ++l;
                ++r;
                continue;
            }
            if (nums[r - 1] + 1 == nums[r]) {
                ++count;
            } else {
                count = 1;
            }
            if (count >= k) {
                result[index++] = nums[l + k - 1];
            } else {
                result[index++] = -1;
            }
            ++l;
            ++r;

        }
        return result;

    }

    public static void main(String[] args) {
        LC3254 s = new LC3254();
        int[] nums ={1,2,3,4,3,2,5};
        s.resultsArray(nums, 3);
        
    }

}
