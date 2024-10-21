/**
 * @param {string} s
 * @return {string}
 */
var removeStars = function(s) {
    const splitArr = (s.split(''));
    const stack = [];
    console.table(splitArr);
    for(let c of splitArr){
        c==='*' ? stack.pop() : stack.push(c);
    }
    return stack.join('');
};
removeStars("leet**cod*e");
removeStars("erase*****");