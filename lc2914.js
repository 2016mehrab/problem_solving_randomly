/**
 * @param {string} s
 * @return {number}
 */
var minChanges = function(s) {
    let count=0;
    let curr=0;
    let ch= s[0];
    let r=0;
    while(curr<s.length){
            ++count;
        if(count%2===0 && s[curr]!==ch){
            ++r;
        }
        ch=s[curr];
        ++curr;

    }
    return r;
    
};
console.log(minChanges('100001'));
