/**
 * @param {number[]} nums
 * @return {boolean}
 */
function getSetBits(num) {
  let binary = Number(num).toString(2);
  const setBits = (binary.match(/1/g) || []).length;
  return setBits;
}
var canSortArray = function (nums) {
  let dynamicSize = nums.length;
  while (dynamicSize >= 0) {
    let noSwap = true;
    for (let j = 1; j < dynamicSize; ++j) {
      if (getSetBits(nums[j - 1]) === getSetBits(nums[j])) {
        if (nums[j - 1] > nums[j]) {
          noSwap = false;
          let tmp = nums[j];
          nums[j] = nums[j - 1];
          nums[j - 1] = tmp;
        }
      }
    }
    if (noSwap) break;
    --dynamicSize;
  }
  for (let curr = 0; curr < nums.length - 1; ++curr) {
    if (!(nums[curr + 1] >= nums[curr])) {
      return false;
    }
  }
  return true;
};

console.log(canSortArray([3, 16, 8, 4, 2]));
console.log(canSortArray([8, 4, 2, 30, 15]));
