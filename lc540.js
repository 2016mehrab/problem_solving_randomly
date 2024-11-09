/**
 * @param {number[]} nums
 * @return {number}
 */
function countEvenNumbers(start, arr) {
  if ((start - arr.length - 1) % 2 === 0) return true;
  return false;
}
var singleNonDuplicate = function (nums) {
  let l = 0;
  let r = nums.length - 1;
  let mid;
  while (l < r) {
    mid = l + Math.floor((r - l) / 2);
    if (nums[mid] !== nums[mid + 1]) {
      if (countEvenNumbers(mid, nums)) {
        r = mid;
      } else l = mid + 1;
    } else {
      if (countEvenNumbers(mid + 1, nums)) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
  }

  return nums[r];
};
console.log(singleNonDuplicate([1,1,2,3,3,4,4,8,8]));
console.log(singleNonDuplicate([3, 3, 7, 7, 10, 11, 11]));
console.log(singleNonDuplicate([1,1,2,2,3]));
