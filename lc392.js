/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isSubsequence = function(s, t) {
    if(s.length> t.length) return false;
    let first=0;
    let second=0;
    while(first<s.length && second<t.length){
        if(s[first]===t[second]){
            ++first;
        }
        ++second;
    }
    if (first===s.length) return true;
    return false;
    
};
console.log(isSubsequence("abc","ahbgdc"));
console.log(isSubsequence("axc","ahbgdc"));
