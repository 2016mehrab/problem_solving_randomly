import java.util.Random;
import java.util.Scanner;

class LC75 {
    static int partition(int[] nums, int start, int end) {
        if (start == end)
            return start;
        Random r = new Random();
        int rn = r.nextInt(end - start + 1) + start;
        // swap mid with last
        int tmp = nums[end];
        nums[end] = nums[rn];
        nums[rn] = tmp;

        int slow = start;
        for (int i = start; i < end; ++i) {
            if (nums[end] > nums[i]) {
                int tmp2 = nums[slow];
                nums[slow] = nums[i];
                nums[i] = tmp2;
                ++slow;
            }
        }
        // reswap
        tmp = nums[end];
        nums[end] = nums[slow];
        nums[slow] = tmp;
        return slow;
    }

    static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int correctIdx = partition(nums, start, end);
            quickSort(nums, start, correctIdx - 1);
            quickSort(nums, correctIdx + 1, end);
        }

    }

    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        LC75 solution = new LC75();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("N: ");
            int N = sc.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; ++i) {
                nums[i] = sc.nextInt();
            }
        }
    }
}
