/**
 * @param {number[]} nums
 * @return {number}
 */
function lowerBound(arr, target) {
  let start = 0;
  let end = arr.length - 1;
  let mid = -1;
  let result = arr.length;
  while (start <= end) {
    mid = Math.round((start + end) / 2);
    if (arr[mid] < target) {
      start = mid + 1;
    } else {
      result = mid;
      end = mid - 1;
    }
  }
  return result;
}

var lengthOfLIS = function (nums) {
    const sortedArr=[];
    for(let curr=0; curr<nums.length;++curr){ 
        let tmp = lowerBound(sortedArr, nums[curr]);
        if(sortedArr.length!==0){
            sortedArr[tmp]=nums[curr];
        }
        else{
            sortedArr.push(nums[curr]);
        }
    }
    // console.table(sortedArr);
    return sortedArr.length;
    
};
// console.log(lengthOfLIS([3, 3, 4, 6, 8, 10, 11, 14, 15, 19]));
console.log(lengthOfLIS([10, 9, 2, 5, 3, 7, 101, 18]));
console.log(lengthOfLIS([0, 1, 0, 3, 2, 3]));
console.log(lengthOfLIS([7, 7, 7, 7, 7, 7, 7]));
