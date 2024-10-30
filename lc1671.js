/**
 * @param {number[]} nums
 * @return {number}
 */
var minimumMountainRemovals = function (nums) {
  const longestIncreasingSubseq = Array.from({ length: nums.length }, () => 1);
  for (let curr = 0; curr < nums.length; ++curr) {
    for (let j = 0; j < curr; ++j) {
      if (
        nums[j] < nums[curr] &&
        longestIncreasingSubseq[curr] < longestIncreasingSubseq[j] + 1
      ) {
        ++longestIncreasingSubseq[curr];
      }
    }
  }
  const longestDecreasingSubseq = Array.from({ length: nums.length }, () => 1);
  for (let curr = nums.length - 1; curr >= 0; --curr) {
    for (let j = nums.length - 1; j > curr; --j) {
      if (
        nums[j] < nums[curr] &&
        longestDecreasingSubseq[curr] < longestDecreasingSubseq[j] + 1
      ) {
        ++longestDecreasingSubseq[curr];
      }
    }
  }
  let result = Infinity;
  for (let curr = 0; curr < nums.length; ++curr) {
    if (
      longestDecreasingSubseq[curr] > 1 &&
      longestIncreasingSubseq[curr] > 1
    ) {
      result = Math.min(
        result,
        curr +
          1 -
          longestIncreasingSubseq[curr] +
          nums.length -
          curr -
          longestDecreasingSubseq[curr]
      );
    }
  }
  return result;
};
// console.log(minimumMountainRemovals([1,3,1]));
// console.log(minimumMountainRemovals([1,3,2,1]));
// console.log(minimumMountainRemovals([2,1,1,5,6,2,3,1]));
console.log(minimumMountainRemovals([9, 8, 1, 7, 6, 5, 4, 3, 2, 1]));
