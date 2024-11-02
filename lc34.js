/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

var searchRange = function (nums, target) {
    function upperBound(){
        let l=0;
        let r=nums.length-1;
        let ub=-1;
        while(l<=r){
            let mid= Math.round((l+r)/2);
            if(nums[mid]===target){
                ub=mid;
                l=mid+1;
            }
            else if(nums[mid]>target){
                r=mid-1;
            }
            else l=mid+1;
        }
        return ub;
    }
    function lowerBound(){
        let l=0;
        let r=nums.length-1;
        let lb=-1;
        while(l<=r){
            let mid= Math.round((l+r)/2);
            if(nums[mid]===target){
                lb=mid;
                r=mid-1;
            }
            else if(nums[mid]>target){
                r=mid-1;
            }
            else l=mid+1;
        }
        return lb;
    }
    const r=[];
    r.push(lowerBound());
    r.push(upperBound());
    return r;

};
console.table(searchRange([5, 7, 7, 8, 8, 10], 8));
console.table(searchRange([5, 7, 7, 8, 8, 10], 6));
console.table(searchRange([], 6));
