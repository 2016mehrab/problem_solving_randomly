import java.util.Arrays;

class LC2563 {
    static int lessEqual(int index, int target, int[] arr) {
        int l = index;
        int p = -1;
        int r = arr.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] > target) {
                r = mid - 1;
            } else {
                p = mid;
                l = mid + 1;
            }
        }
        if (p == -1) return -1;
        
        return p;
    }

    static int lessThan(int index, int target, int[] arr) {
        int l = index;
        int p = -1;
        int r = arr.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] >= target) {
                r = mid - 1;
            } else {
                p = mid;
                l = mid + 1;
            }
        }
        if (p == -1) return -1;
        
        return p;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        // count the pairs lower than LOWER
        // count the pairs lower and equal to UPPER
        // subtract them
        Arrays.sort(nums);
        long sum=0;
        for (int i = 0; i < nums.length; ++i) {
            int tmp1= lessThan(i + 1,lower - nums[i], nums);
            int tmp2= lessEqual(i + 1,upper - nums[i], nums);
            // problems for  {-5,-7,-5,-7,-5} input.
            int pairsSmallerThanLower= tmp1==-1?0:tmp1-i;
            int pairsSmallerEqualToUpper=tmp2==-1?0: tmp2-i;
            if(pairsSmallerEqualToUpper==0 & pairsSmallerThanLower==0) break;
            sum+=pairsSmallerEqualToUpper-pairsSmallerThanLower;
        }
        return sum;

    }

    public static void main(String[] args) {
        LC2563 s = new LC2563();
        // int [] arr= {0,1,2,3,7,4,4,5};
        int[] arr = { 0, 1, 7, 4, 4, 5 };
        int[] arr1 = {-5,-7,-5,-7,-5};
        // s.countFairPairs(arr, 3, 6);
        s.countFairPairs(arr1, -12, -12);
        Arrays.sort(arr1);
        
        for (int i : arr1) {
            System.out.print(i+" ");
            
        }
        System.out.println();
        System.out.println(lessEqual(0, -7, arr1));
        System.out.println(lessThan(0, -3, arr1));
    }

}
