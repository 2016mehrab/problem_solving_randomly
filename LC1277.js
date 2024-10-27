/**
 * @param {number[][]} matrix
 * @return {number}
 */
let saved=[];
function find(row, column, matrix){
    if(row>= matrix.length || column>=matrix[0].length || matrix[row][column]===0){
        return 0;
    }
    else if(saved[row][column]!==-1){
        return saved[row][column];
    }
    else{
        let right = find(row, column+1, matrix);
        let down = find(row+1, column, matrix);
        let diagonal= find(row+1, column+1, matrix);
        let tmp = 1+Math.min(right,down,diagonal);
        saved[row][column]=tmp;
        return tmp;
    }

}
var countSquares = function(matrix) {
    for(let row =0; row<matrix.length; ++row){
        saved[row]=[]
        for(let column=0; column<matrix[0].length;++column){
            saved[row].push(-1);
        }
    }
    let sum=0;
    for(let row =0; row<matrix.length; ++row){
        for(let column=0; column<matrix[0].length;++column){
            if(matrix[row][column]!==0){
               sum+= find(row, column, matrix);
            }
        }
    }
    console.table(saved);
    console.log(sum);
   return sum; 
};
countSquares(
    [
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
)