/**
 * @param {number} n
 * @return {number}
 */
// const arr = Array(46).fill(-1);
// function dive(index, target) {
//   if (arr[index] !== -1) {
//     return arr[index];
//   }
//   if (index === target) {
//     return 1;
//   }
//   if (index > target) return 0;
//   let stepone = dive(index + 1, target);
//   let steptwo = dive(index + 2, target);
//   arr[index] = stepone + steptwo;
//   return stepone + steptwo;
// }
var climbStairs = function (n) {
  const arr = Array(46).fill(-1);
  function dive(index, target) {
    if (index === target) {
      return 1;
    }
    if (index > target) {
      return 0;
    }
    if (arr[index] !== -1) {
      return arr[index];
    }
    let stepone = dive(index + 1, target);
    let steptwo = dive(index + 2, target);
    arr[index] = stepone + steptwo;
    return stepone + steptwo;
  }
  dive(0, n);
  return dive(0, n);
};

console.log(climbStairs(45));
