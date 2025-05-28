class LC3372 {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        // first make adjlist
        int n= edges1.length+1;
        int m= edges2.length+1;
        ArrayList<Integer>[] adjlist1 = new ArrayList[n];
        for(int i=0; i<n;++i) adjlist1[i] = new ArrayList<>();
        
        ArrayList<Integer>[] adjlist2 = new ArrayList[m];
        for(int i=0; i<m;++i) adjlist2[i] = new ArrayList<>();
        
        for(var edge: edges1){
            int u =edge[0];
            int v =edge[1];
            adjlist1[u].add(v);
            adjlist1[v].add(u);
        }
        
        for(var edge: edges2){
            int u =edge[0];
            int v =edge[1];
            adjlist2[u].add(v);
            adjlist2[v].add(u);
        }

        // count k-1 nodes from tree2 using bfs 
        int [] target2= new int[m];
        int maxval=-1;
        for(int i=0; i<m;++i){
        boolean [] visit2= new boolean[m];
           var targets=bfs(i,adjlist2,k-1, visit2);
            target2[i]= targets;
            maxval= Math.max(maxval, targets);
        }
        // count k nodes from tree1 using bfs 
        int [] target1= new int[n];
        for(int i=0; i<n;++i){
        boolean [] visit1= new boolean[n];
           var targets=bfs(i,adjlist1,k,visit1);
            target1[i]= targets;
        }
        //debug
        for(int i=0; i<n;++i){
            System.out.print(target1[i]+" ");
        }
        System.out.println();
        for(int i=0; i<m;++i){
            System.out.print(target2[i]+" ");
        }
        // add the highest of tree2 to each node of answer
        int[]ans = new int[n];
        if(k==0) return target1;
        for(int i=0; i<n;++i){
           ans[i] =target1[i]+maxval; 
        }
        return ans;
    }
    private int bfs(int node ,ArrayList<Integer>[] adjlist1 ,int k, boolean[]visit ){
           Queue<Integer>  q= new LinkedList<>();
        int cnt=1;
        int level=0;
        q.add(node);
        visit[node]=true;
        while(!q.isEmpty() && level<k){
            int levelnodes = q.size() ;
            for(int i=0; i<levelnodes;++i){
                var curr =q.poll();
                int size = adjlist1[curr].size();
                for(int n=0;n<size;++n){
                   var ngbr = adjlist1[curr].get(n);
                    if(!visit[ngbr]){
                        visit[ngbr]=true;
                        q.add(ngbr);
                        ++cnt;
                    }
                }
                
            }
            
            ++level;
        }
        return cnt;
    }
    public static void main(String[] args) {
        LC3372 solution = new LC3372();
        
    }
}
