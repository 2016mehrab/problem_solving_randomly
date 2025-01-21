class LC2017 {
    public long gridGame(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        long[]rowPrefix_1 = new long[N];
        long[]rowPost= new long[N];
        long firstRowTotal = 0;
        long secondRowTotal = 0;
        for(int col =0 ;col<N; ++col){
            if(col==0){
rowPrefix_1[col]=grid[0][col];
            firstRowTotal += grid[0][col];
                continue;
            } 
            rowPrefix_1[col]= grid[0][col] +rowPrefix_1[col-1];
            firstRowTotal += grid[0][col];
        }

        for(int col =N-1 ;col>-1; --col){

            if(col==N-1) {
                rowPost[col]= grid[1][col];
                secondRowTotal += grid[1][col];
                continue;
            }

            rowPost[col]= grid[1][col] + rowPost[col+1];
                secondRowTotal += grid[1][col];


        }

        long r= Long.MAX_VALUE;
        for(int col=0; col< N ;++col){
            // if robot 1 change direction in col =1
            long points_from_first_row = firstRowTotal - rowPrefix_1[col];
            long points_from_sec_row = secondRowTotal - rowPost[col];

            long tmp=points_from_first_row  > points_from_sec_row ? points_from_first_row:points_from_sec_row ;

            r= Math.min(r, tmp);

        }
        System.out.println(r);
        return r;
    }

    public static void main(String[] args) {

        LC2017 solution = new LC2017();
        
        int[][] g1={ { 2,5,4 },{ 1,5,1 } };
        int[][]g2 ={ { 3,3,1 },{ 8,5,2 } };
        solution.gridGame(g1);
        solution.gridGame(g2);
    }
}
