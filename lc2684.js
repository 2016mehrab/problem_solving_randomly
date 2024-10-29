var maxMoves = function (grid) {
  const saved = Array.from({ length: grid.length }, () =>
    Array.from({ length: grid[0].length }, () => -1)
  );

  function dive(r, c, val) {
    if (
      r >= grid.length ||
      r < 0 ||
      c >= grid[0].length ||
      (grid[r][c] <= val && c !== 0)
    ) {
      return 0;
    }

    if (saved[r][c] !== -1) {
      return saved[r][c];
    }

    let result =
      1 +
      Math.max(
        dive(r - 1, c + 1, grid[r][c]),
        dive(r, c + 1, grid[r][c]),
        dive(r + 1, c + 1, grid[r][c])
      );
    saved[r][c] = result;
    return result;
  }
  // visit row,1
  let max = -1;
  for (let row = 0; row < grid.length; ++row) {
    let col = 0;
    max = Math.max(max, dive(row, col, grid[row][col]));
  }
  return max-1;
};

console.log(
  maxMoves([
    [2, 4, 3, 5],
    [5, 4, 9, 3],
    [3, 4, 2, 11],
    [10, 9, 13, 15],
  ])
);
console.log(
  maxMoves([
    [3, 2, 4],
    [2, 1, 9],
    [1, 1, 7],
  ])
);
