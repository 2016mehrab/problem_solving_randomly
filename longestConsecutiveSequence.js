function longestConsecutive(nums) {
    if (!nums.length) return 0;
    let s = new Set(nums);

    let start=[];
    for(let c of s){
        if(!s.has(c-1)) start.push(c);
    }
    let seqCount=[];
    for(let n of nums){
        let result=1;
        while(s.has(++n)) {
            ++result;
        }
        seqCount.push(result);
    }
    let max=seqCount[0];
    for(let n of seqCount)  n>max? max =n : 0;
    return max;

}
console.log(longestConsecutive([0,3,2,5,4,6,1,1]));

