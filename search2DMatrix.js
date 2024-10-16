function searchMatrix(matrix, target) {
  // matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]]
  let m = matrix.length;
  let n = matrix[0].length;
  let up = 0;
  let down = m-1;
  while (up <= down) {
    // let binaryCurrent = up + Math.floor((down-up) / 2);
    let binaryCurrent = Math.floor((down + up) / 2);
    if (
      target >= matrix[binaryCurrent][0] &&
      target <= matrix[binaryCurrent][n - 1]
    ) {
      up = 0;
      down = n - 1;
      while (up <= down) {
        // let current = up + Math.floor((down-up)/ 2);
        let current = Math.floor((down + up) / 2);
        if (matrix[binaryCurrent][current] === target) {
          return true;
        } else if (matrix[binaryCurrent][current] < target) {
          up = current + 1;
        } else down = current - 1;
      }
      return false;
    } else if (matrix[binaryCurrent][0] < target) {
      up = binaryCurrent + 1;
    } else {
      down = binaryCurrent - 1;
    }
  }
  return false;
}

let matrix = [
  [1, 2, 4, 8],
  [10, 11, 12, 13],
  [14, 20, 30, 40],
];
let ymatrix = [
  [1, 3, 5, 7],
  [10, 11, 16, 20],
  [23, 30, 34, 60],
];
let xmatrix = [
  [1, 3, 5, 7],
  [10, 11, 16, 20],
  [23, 30, 34, 60],
];
// console.log(searchMatrix(xmatrix, 13));
// console.log(searchMatrix(matrix, 10));
console.log(searchMatrix([[1]], 2));
