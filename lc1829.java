import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LC1829 {
    public static int reverseBits(int mask,int num){
        return mask ^ num;
    }
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int range= (int)Math.round(Math.pow(2,maximumBit))-1;
        Set<Integer> set= IntStream.range(0,(int)Math.round(Math.pow(2,maximumBit)) ).boxed().collect(Collectors.toSet());
        int []r= new int[nums.length];
        int total=0;
        for (int curr=0; curr<nums.length;++curr) {
            total=total ^ nums[curr];
            int tmp=reverseBits(range, total);
            if(set.contains(tmp)){
                r[nums.length-curr-1] =tmp;
            }

        }
        // List<Integer>n= Arrays.stream(r).boxed().collect(Collectors.toList());
        // System.out.println(n);

        return r;
    }
    public static void main(String[] args) {
       LC1829 s = new LC1829(); 
    //    int[]arr= {0,1,1,3};
       int[]arr= {2,3,4,7};
       s.getMaximumXor(arr, 3);
       System.out.println(Math.round(Math.pow(2, 4)));
    }

}
