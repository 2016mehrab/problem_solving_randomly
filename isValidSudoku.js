let board = 
[
    ["1","2",".",".","3",".",".",".","."],
 ["4",".",".","5",".",".",".",".","."],
 [".","9","1",".",".",".",".",".","3"],
 ["5",".",".",".","6",".",".",".","4"],
 [".",".",".","8",".","3",".",".","5"],
 ["7",".",".",".","2",".",".",".","6"],
 [".",".",".",".",".",".","2",".","."],
 [".",".",".","4","1","9",".",".","8"],
 [".",".",".",".","8",".",".","7","9"]
];

function isValidSudoku(board) {
  let col= new Map();
  let row= new Map();
   let square = new Map();
  for (let r = 0; r < board.length; ++r) {
    for (let c = 0; c < board[0].length; ++c) {
      if (board[r][c] === ".") continue;
      if (!col.has(c)) col.set(c, new Set());
      if (!row.has(r)) row.set(r, new Set());
      let sq = Math.floor(r / 3) + "," + Math.floor(c / 3);
      if (!square.has(sq)) square.set(sq, new Set());
      if (
        row.get(r).has(board[r][c]) ||
        col.get(c).has(board[r][c]) ||
        square.get(sq).has(board[r][c])
      ) {
        return false;
      }
      col.get(c).add(board[r][c]);
      row.get(r).add(board[r][c]);
      square.get(sq).add(board[r][c]);

    }
  }
  return true;
}

console.log(isValidSudoku(board));

