/**
 * @param {string} s
 * @param {string} goal
 * @return {boolean}
 */
var rotateString = function (s, goal) {
    if(s.length!==goal.length) return false;
    const rotatedArr = goal.split("");
    for(let i=0; i<s.length;++i){
        let tmp = rotatedArr.pop();
        rotatedArr.unshift(tmp);
        if(rotatedArr.join("")===s) return true;
    }
    return false;
    

};
console.log(rotateString("abcde", "cdeab"));
console.log(rotateString("abcde", "abced"));
console.log(rotateString("defdefdefabcabc","defdefabcabcdef"));
