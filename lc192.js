/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    if(nums.length<2){
        return Math.max(...nums);
    }

    const saved=Array(nums.length+1).fill(-1);
    saved[1]=nums[0];
    for (let curr = 1; curr < nums.length; ++curr) {
        let tmp = saved[curr+1-2] < 0? 0 : saved[curr+1-2];
        saved[curr+1]=Math.max((nums[curr]+tmp),saved[curr+1-1]);
    }
    
    return saved;
};
rob([2,7,9,3,1]);