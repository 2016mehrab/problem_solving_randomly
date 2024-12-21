import java.util.ArrayList;
import java.util.List;

class LC2872 {
     public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
         List<Integer>[] adjList =new ArrayList[n];
         for(int i =0; i < n ; ++i) adjList[i] = new ArrayList<>();
         for(int[] edge: edges){
             adjList[edge[0]].add(edge[1]);
             adjList[edge[1]].add(edge[0]);
         }
         int [] res = {0};
         dfs(0, -1,  adjList, values ,k ,res);
         System.out.println(res[0]);
         return res[0];
     }
     private int dfs(int curr, int parent , List<Integer> [] adjList, int[] values, int k ,int[] res){
         int sum =0;
         for(int n : adjList[curr]){
             if(n!= parent)
                 sum+= dfs(n, curr, adjList, values,k, res);
         }
        sum+= values[curr];
         if(sum%k==0) res[0]+=1;
         return sum%k;
     }

    public static void main(String[] args) {
        LC2872 solution = new LC2872();
        int[][]e1= { { 0,2 },{ 1,2 },{ 1,3 },{ 2,4 } };
        int [] v1 = { 1,8,1,4,4 };
        int[][] e2 = { { 0,1 },{ 0,2 },{ 1,3 },{ 1,4 },{ 2,5 },{ 2,6 } };
        int [] v2 ={ 3,0,6,1,5,2,1 };
        int [][]e3= { { 0,1 },{ 0,2 },{ 1,3 },{ 1,4 },{ 2,5 },{ 2,6 } };
        int [] v3 ={ 3,0,6,1,5,2,1 };
        int [][]e4 = {{0,1}, {0,2}};
        int []v4 = {6, 3, 3};
        int []v5 = {2, 1, 3};

        solution.maxKDivisibleComponents(5, e1, v1, 6);
        solution.maxKDivisibleComponents(7, e2, v2, 3);
        solution.maxKDivisibleComponents(7, e3, v3, 3);
        solution.maxKDivisibleComponents(3, e4, v4, 6);
        solution.maxKDivisibleComponents(3, e4, v5, 3);
        
    }
}
