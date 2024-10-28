/**
 * @param {number[]} nums
 * @return {number}
 */
var longestSquareStreak = function (nums) {
  let set = new Set(nums);
  let result = -1;
  for (let n of nums) {
    if (
      n !== 1 &&
      Number.isInteger(Math.sqrt(n)) &&
      set.has(Math.sqrt(n))
    ) {
      let count = 1;
      let c=n;
      while (
        Number.isInteger(Math.sqrt(c)) &&
        set.has(Math.sqrt(c))
      ) {
        count++;
        c=Math.sqrt(c);
      }
      result=Math.max(count, result);
    }
  }
  console.log('result->',result);
  
  return result;
};
longestSquareStreak([4, 3, 6, 16, 8, 2]);
longestSquareStreak([2, 3, 5, 6, 7]);
