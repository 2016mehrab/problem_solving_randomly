/**
 * @param {number} n
 * @return {boolean}
 */
// only positive integers considered ugly
var isUgly = function (n) {
  let num =(n) ;
  while (num > 1) {
    if (num % 2 === 0 || num % 5 === 0 || num % 3 === 0) {
      num % 2 === 0 ? (num = num / 2) : null;
      num % 3 === 0 ? (num = num / 3) : null;
      num % 5 === 0 ? (num = num / 5) : null;
    }
    else return false;
  }
  return num===1;
};

console.log(

isUgly(-2147483648)
);
