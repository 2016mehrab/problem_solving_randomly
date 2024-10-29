/**
 * @param {number[]} nums
 * @return {number}
 */

var robTree = function (nums) {
  if (nums.length <= 2) {
    return Math.max(...nums);
  }
  let saved = Array(nums.length + 1).fill(-1);
  const dive = (indexS, indexL, arr) => {
    if (indexS >= arr.length || indexS > indexL) return 0;
    if (saved[indexS] !== -1) return saved[indexS];
    let diveLeft = arr[indexS] + dive(indexS + 2, indexL, arr);
    let diveRight = dive(indexS + 1, indexL, arr);
    saved[indexS] = Math.max(diveLeft, diveRight);
    return Math.max(diveLeft, diveRight);
  };

  let stealFirst = dive(0, nums.length - 2, nums);
  console.table(saved);
  saved = Array(nums.length + 1).fill(-1);
  let stealLast = dive(1, nums.length - 1, nums);
  console.table(saved);
  console.log(stealFirst, "<->", stealLast);
  return Math.max(stealFirst, stealLast);
};

var rob = function (nums) {
  if (nums.length <= 2) return Math.max(...nums);
  let prev = 0;
  let prev_prev = 0;
  let with_first;
  for (let i = 0; i <= nums.length - 2; ++i) {
    let tmp = Math.max(nums[i] + prev_prev, prev);
    prev_prev = prev;
    prev = tmp;
  }
  with_first = prev;
  prev = 0;
  prev_prev = 0;

  for (let i = 1; i <= nums.length - 1; ++i) {
    let tmp = Math.max(nums[i] + prev_prev, prev);
    prev_prev = prev;
    prev = tmp;
  }
  console.log(Math.max(with_first, prev));

  return Math.max(with_first, prev);
};

rob([
  94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61, 6, 237, 12, 72, 74, 29,
  95, 265, 35, 47, 1, 61, 397, 52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86,
  81, 72,
]);
console.log(rob([1 ]));

// rob([1, 2, 3, 1]);
// rob([2, 3, 2]);
// rob([1, 2, 3]);
// rob([3, 4]);
