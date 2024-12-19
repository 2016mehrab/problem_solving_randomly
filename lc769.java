class LC769 {
    public int maxChunksToSortedPrefixSum(int[] arr) {
        int prefixSum = 0, sortedSum =0, chunks=0;
        for(int i =0; i < arr.length; ++i){
            prefixSum+=arr[i];
            sortedSum+=i; 
            if(prefixSum== sortedSum) ++chunks;
        }
        return chunks;
    }

    public int maxChunksToSorted(int[] arr) {
        int chunks=0;
        int max=-1;
        for(int i =0; i < arr.length; ++i){
            if(max<arr[i]){
                max = arr[i];
            }
            if(max==i) ++chunks;
        }
        return chunks;
    }

    public int maxChunksToSortedMonotonicStack(int[] arr) {
        int N = arr.length;
        int[] stack =new int[N];
        int stackPtr= 0;
        int max=-1;
        for(int i =0; i < N; ++i){
            if(max<arr[i]){
                max = arr[i];
            }
            if(stackPtr!=0){
               while(stackPtr!=0 && arr[i] < stack[stackPtr -1]) {
                    --stackPtr;
               }
                stack[stackPtr++] = max;
            }
            else stack[stackPtr++] = arr[i];

        }
        return stackPtr;
    }
    public static void main(String[] args) {
        LC769 solution = new LC769();
        
    }
}
