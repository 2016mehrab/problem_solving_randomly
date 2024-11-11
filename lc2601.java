import java.util.Arrays;

class LC2601 {
    static void sieve(Boolean [] primeArr) {
        Arrays.fill(primeArr,true);
        primeArr[0] = false;
        primeArr[1] = false;
        for (int i = 2; (i * i) <= 1000; ++i) {
            if (primeArr[i]) {
                for (int j = i * i; j < 1001; j += i) {
                    primeArr[j] = false;
                }
            }
        }
    }
    public boolean primeSubOperation(int[] nums) {
        Boolean[] primeArr = new Boolean[1001];
        sieve(primeArr);
        for(int i=nums.length-2; i>=0;--i){
            if(nums[i]< nums[i+1]){
                continue;
            }
            for(int p=2; p<nums[i];p++){
                if(!primeArr[p]){
                    continue;
                }
                if((nums[i]-p)<nums[i+1]){
                    nums[i]-=p;
                break;
                }
            }
            if(nums[i]>= nums[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    int[] arr= {4,9, 6,10};
    LC2601 s = new LC2601();
    s.primeSubOperation(arr);
    }

}
