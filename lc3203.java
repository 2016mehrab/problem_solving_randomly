import java.util.ArrayList;

class LC3203 {
    private ArrayList<Integer>[] createAdjList(int[][]edges){
        int N = edges.length;
        ArrayList<Integer>[] adjList= new ArrayList[N+1];
        for(int i=0 ;i<N+1;++i){
            adjList[i] =new ArrayList<>();
        }
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }
        return adjList;
    }
    private int dfs(int curr, int parent, ArrayList<Integer>[] adjList ,int[] result){
        int maxpath =0;
        int nextmaxpath =0;
        for(int neighbor: adjList[curr]){
            if(neighbor == parent) continue;
            int path =dfs(neighbor, curr, adjList, result) ;
            if(path > maxpath){
                nextmaxpath= maxpath;
                maxpath = path;
            }
            else if( path > nextmaxpath) nextmaxpath =path;
        }
        int tmpDiameter=  maxpath + nextmaxpath;
        result[0] = result[0] > tmpDiameter ? result[0] : tmpDiameter;
        return 1+maxpath;
    }

    private int getDiameter(ArrayList<Integer>[] adjList){
        int[] res = {0};
        dfs(0, -1, adjList, res);
        return res[0];
    }

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        ArrayList<Integer>[] adjList1=createAdjList(edges1);
        ArrayList<Integer>[] adjList2=createAdjList(edges2);
        int diameter1 =getDiameter(adjList1);
        int diameter2 =getDiameter(adjList2);
        int mergedDiameter =(int) Math.ceil((double)diameter1/2) +(int) Math.ceil((double)diameter2/2) +1;
        return Math.max(mergedDiameter, Math.max(diameter1, diameter2));
    }

    public static void main(String[] args) {
        LC3203 solution = new LC3203();
        int[][]e1={ { 0,1 },{ 0,2 },{ 0,3 } };
        int [][]e2 = { { 0,1 } };
        int[][]e3={ { 0,1 },{ 1,2 },{ 0,3 } };
        int [][]e4 = { { 0,1 } ,{0,2} };
        int [][]e5={ { 0,1 },{ 2,0 },{ 3,2 },{ 3,6 },{ 8,7 },{ 4,8 },{ 5,4 },{ 3,5 },{ 3,9 } };
        int [][] e6={ { 0,1 },{ 0,2 },{ 0,3 } };
        // System.out.println(solution.minimumDiameterAfterMerge(e1, e2));
        //System.out.println(solution.minimumDiameterAfterMerge(e3, e4));
        System.out.println(solution.minimumDiameterAfterMerge(e5, e6));
        ;
    }
}
