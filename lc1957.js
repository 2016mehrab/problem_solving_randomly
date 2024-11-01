/**
 * @param {string} s
 * @return {string}
 */
var makeFancyString = function (s) {
  let result = s[0];
  let tmp = 1;
  for (let i = 1; i < s.length; ++i) {
    if (s[i] === s[i - 1]) {
      ++tmp;
      if (tmp >= 3) {
        continue;
      }
    } else {
      tmp = 1;
    }
    result += s[i];
  }
  return result;
};
console.log(makeFancyString("leeetcode"));
console.log(makeFancyString("aaabaaaa"));
console.log(makeFancyString("aab"));
