/**
 * @param {string} word
 * @return {string}
 */
var compressedString = function (word) {
  let comp = "";
  let curr = 0;
  while (curr < word.length) {
    let repeat = 0;
    let letter = word[curr];
    while (curr < word.length && repeat < 9 && word[curr] === letter) {
      ++curr;
      ++repeat;
    }
    comp += repeat + letter;
  }
  return comp;
};
console.log(compressedString("abcde"));
console.log(compressedString("aaaaaaaaaaaaaabb"));
