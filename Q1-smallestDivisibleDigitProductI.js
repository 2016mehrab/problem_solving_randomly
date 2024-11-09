/**
 * @param {number} n
 * @param {number} t
 * @return {number}
 */

var smallestNumber = function (n, t) {
  function prdct(numArr) {
    let p = 1;
    for (let i of numArr) {
      p *= parseInt(i);
    }
    return p;
  }
  let ntmp=n;
  let min = -1;
  while (true) {
    ntmp = ntmp + "";
    ntmp = ntmp.split("");
    if (prdct(ntmp) % t===0) {
      min =parseInt(ntmp.join("")) ;
      break;
    }
    ntmp=parseInt(ntmp.join(""));
    ++ntmp;
  }
  return min;
};
console.log(smallestNumber(10, 2));
console.log(smallestNumber(15, 3));
