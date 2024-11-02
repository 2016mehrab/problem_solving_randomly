/**
 * @param {string} sentence
 * @return {boolean}
 */
var isCircularSentence = function (sentence) {
  let tmp = sentence.split(" ");
  let lastWord = tmp[tmp.length - 1];
  if (tmp[0][0] !== lastWord[lastWord.length - 1]) {
    return false;
  }
  for (let i = 0; i < tmp.length - 1; ++i) {
    let wordSize = tmp[i].length;
    if (tmp[i][wordSize - 1] !== tmp[i + 1][0]) {
      return false;
    }
  }
  return true;
};
console.log(isCircularSentence("leetcode exercises sound delightful"));
console.log(isCircularSentence("Leetcode is cool"));
