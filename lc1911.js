/**
 * @param {number[]} nums
 * @return {number}
 */
var maxAlternatingSum = function (nums) {
  const map = new Map();
  function solve(index, flag) {
    if (index >= nums.length) return 0;
    const key = `${index}^${flag}`;
    if (map.has(key)) return map.get(key);
    let val = nums[index];
    if (!flag) val = -val;
    let take = solve(index + 1, !flag) + val;
    let skip = solve(index + 1, flag);
    let result = Math.max(take, skip);
    map.set(key, result);
    return result;
  }
  return solve(0, true);
};
console.log(maxAlternatingSum([4, 2, 3]));
console.log(maxAlternatingSum([4, 2, 5, 3]));
console.log(maxAlternatingSum([6, 2, 1, 2, 4, 5]));
