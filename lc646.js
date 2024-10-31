/**
 * @param {number[][]} pairs
 * @return {number}
 */
var findLongestChain = function (pairs) {
  pairs.sort((f, l) => {
    if (f[0] > l[0]) return 1;
    else if (f[0] === l[0]) {
      if (f[1] > l[1]) return 1;
      return -1;
    }
    return -1;
  });
  const longestIncreasingSubseq = Array.from({ length: pairs.length }, () => 1);
  for (let curr = 0; curr < pairs.length; ++curr) {
    for (let j = 0; j < curr; ++j) {
      if (
        pairs[j][1] < pairs[curr][0] &&
        longestIncreasingSubseq[curr] < longestIncreasingSubseq[j] + 1
      ) {
        ++longestIncreasingSubseq[curr];
      }
    }
  }
  return Math.max(...longestIncreasingSubseq);
};

console.log(
  findLongestChain([
    [1, 2],
    [2, 3],
    [3, 4],
    [3, 6],
  ])
);
console.log(
  findLongestChain([
    [1, 2],
    [7, 8],
    [4, 5],
  ])
);
