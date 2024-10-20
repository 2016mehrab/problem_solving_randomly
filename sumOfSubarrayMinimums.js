// duplication case [2,6,2,4,2]
// [2,6,2]
// [2,6,2,4]
// [2,6,2,4,2] all of this will be repeated if we consider another 2 as equal in both.
// left array and right array. But those subarrays should have the minimum 2.
/**
 * @param {number[]} arr
 * @return {number}
 */
function leftMinimumArray(arr) {
  const stack = [];
  const result = [];
  for (let index = 0; index < arr.length; ++index) {
    if (stack.length === 0) {
      result.push(-1);
    } else {
      while (arr[stack[stack.length - 1]] > arr[index]) {
        stack.pop();
      }
      result.push(stack.length === 0 ? -1 : stack[stack.length - 1]);
    }
    stack.push(index);
  }
  console.table(result);
  return result;
}
function rightMinimumArray(arr) {
  const stack = [];
  const result = Array(arr.length).fill(0);
  for (let index = arr.length - 1; index >= 0; --index) {
    if (stack.length === 0) {
      result[index] = arr.length;
    } else {
      while (arr[stack[stack.length - 1]] >= arr[index]) {
        stack.pop();
      }
      result[index] = stack.length === 0 ? arr.length : stack[stack.length - 1];
    }
    stack.push(index);
  }
  console.table(result);
  return result;
}

var sumSubarrayMins = function (arr) {
  const MOD = 1000000007;
  const leftRange=leftMinimumArray(arr);
  const rightRange=rightMinimumArray(arr);
  let sum=0;
  for (let index = 0; index < arr.length; index++) {
    const subarraySum = arr[index] * (index-leftRange[index]) * (rightRange[index]-index);
    sum+=subarraySum;
  }
  return sum%MOD;
};

// leftMinimumArray([0, 3, 4, 5, 2, 3, 4, 1, 4]);
// rightMinimumArray([0, 3, 4, 5, 2, 3, 4, 1, 4]);
sumSubarrayMins([3,1,2,4])