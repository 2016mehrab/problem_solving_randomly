/**
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */

var longestCommonSubsequenceTree = function (text1, text2) {
  const map = new Map();
  function solve(i, j) {
    if (i >= text1.length || j >= text2.length) return 0;
    const key = `${i}-${j}`;
    if (map.has(key)) {
      return map.get(key);
    }
    let first = -Infinity;
    let second = -Infinity;
    let r;
    if (text1[i] === text2[j]) {
      r = 1 + solve(i + 1, j + 1);
    } else {
      first = solve(i, j + 1);
      second = solve(i + 1, j);
      r = Math.max(first, second);
    }
    map.set(key, r);
    return r;
  }
  return solve(0, 0);
};

var longestCommonSubsequence = function (text1, text2) {
  //  bottomUpArr[row][column] indicates the size of longest common subsequence up until that point
  const bottomUpArr = Array.from({ length: text1.length + 1 }, () => {
    return Array.from({ length: text2.length + 1 }, () => 0);
  });

  for (let r = 0; r < text1.length; ++r) {
    for (let c = 0; c < text2.length; ++c) {
      if (text1[r] === text2[c]) {

        bottomUpArr[r + 1][c + 1] = bottomUpArr[r ][c] + 1;
      } else {
        bottomUpArr[r + 1][c + 1] = Math.max(
          bottomUpArr[r][c + 1],
          bottomUpArr[r + 1][c]
        );
      }
    }
  }
  //   console.table(bottomUpArr);
  return bottomUpArr[text1.length][text2.length];
};
console.log(longestCommonSubsequence("abcba", "abcbcba"));
// console.log(longestCommonSubsequence("abcde", "ace"));
// console.log(longestCommonSubsequence("abc", "abc"));
// console.log(longestCommonSubsequence("abc", "def"));
