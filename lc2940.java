import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// how many queries till index i?
// put all of those in an arraylist
// loop through the heights 
// for each curr index check if the curr element is greater than any queries' max element in the list
class LC2940 {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int N= queries.length;
        int[] res= new int[N];
        Map<Integer,ArrayList<int[]>> map =  new HashMap<>();
        // [max height, query index]
        Queue<int[]> q =new PriorityQueue<int[]>((f,l) ->Integer.compare(f[0] , l[0]) );

        for(int i=0; i< N; ++i) res[i]=-1;
         
        // answering easy queries
        for(int i =0 ; i < N; ++i){
            if(queries[i][0]> queries[i][1]) {
                int tmp =queries[i][1];
                queries[i][1]=queries[i][0];
                queries[i][0]=tmp;
            }
            if(heights[queries[i][1]] > heights[queries[i][0]] || queries[i][1] == queries[i][0]) res[i] = queries[i][1];
            else{
                map.putIfAbsent(queries[i][1], new ArrayList<>());
                map.get(queries[i][1]). add(new int []{Math.max(heights[queries[i][1]], heights[queries[i][0]]), i});
            }
            
        }
        for(int curr = 0; curr< heights.length; ++curr){
            if(map.containsKey(curr)){
                // map.get contains all queries till curr index
                for(int [] query: map.get(curr)){
                    q.add(query);
                }
            }

                while(!q.isEmpty() && q.peek()[0] < heights[curr]){
                    res[q.poll()[1]] = curr;
                }
        }
        return res;
    }
    public static void main(String[] args) {
        LC2940 solution = new LC2940();
        int[] h1 = { 6,4,8,5,2,7 };
        int [][]q1={ { 0,1 },{ 3,0 },{ 4,2 },{ 3,4 },{ 2,2 } };
        int[] h2 = { 5,3,8,2,6,1,4,6 };
        int [][]q2={ { 0,7 },{ 3,5 },{ 5,2 },{ 3,0 },{ 1,6 } };
        int [] h3 ={ 1,2,1,2,1,2 };
        int [][]q3= {{ 0,2 },{ 0,3 },{ 0,4 }};
        solution.leftmostBuildingQueries(h1, q1);
        solution.leftmostBuildingQueries(h2, q2);
        solution.leftmostBuildingQueries(h3, q3);
        
    }
}
