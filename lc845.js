/**
 * @param {number[]} arr
 * @return {number}
 */
var longestMountain = function(arr) {
    const leftside=Array.from({length:arr.length}, ()=>1);
    const rightside=Array.from({length:arr.length}, ()=>1);
    for(let curr =1;curr<arr.length; ++curr ){
        if(arr[curr]> arr[curr-1]){
            leftside[curr] = leftside[curr-1]+1;
        }
    }
    for(let curr =arr.length-2;curr>=0; --curr ){

        if(arr[curr]> arr[curr+1]){
            rightside[curr] =rightside[curr+1]+1;
        }
    }
    let longestMountain=0;
    for(let curr =1;curr<arr.length; ++curr ){
        if(leftside[curr]>1 && rightside[curr]>1){
            longestMountain=Math.max(longestMountain, leftside[curr]+rightside[curr]-1);
        }
    }
    return longestMountain;
    
};
console.log(longestMountain([2,1,4,7,3,2,5]));
console.log(longestMountain([2,2,2]));
