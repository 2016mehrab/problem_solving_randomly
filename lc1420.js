/**
 * @param {number} n
 * @param {number} m
 * @param {number} k
 * @return {number}
 */

var numOfArraysWithArrays = function (n, m, k) {
  const result = [];
  const list = Array.from({ length: m }, (_, i) => i + 1);
  function sizeTwoArr(s, list, createdList, prev, searchCost) {
    if (searchCost > k) {
      return;
    }
    if (s === n) {
      result.push([...createdList]);
      return;
    }
    for (let l of list) {
      createdList.push(l);
      let prev_tmp = prev;
      let search_tmp = searchCost;
      if (prev < l) {
        prev = l;
        ++searchCost;
      }
      sizeTwoArr(s + 1, list, createdList, prev, searchCost);
      prev = prev_tmp;
      searchCost = search_tmp;
      createdList.pop();
    }
  }
  sizeTwoArr(0, list, [], -1, 0);
  console.table(result);
  return result.length % 1000000007;
};

var numOfArrays = function (n, m, k) {
  const list = Array.from({ length: m }, (_, i) => i + 1);
  const map = new Map();
  function sizeTwoArr(s, list, prev, searchCost) {
    if (s === n && searchCost === k) {
      return 1;
    }
    if (searchCost > k || s === n) {
      return 0;
    }
    const key = `${s}-${searchCost}-${prev}`;
    if (map.has(key)) {
      return map.get(key);
    }

    let r = 0;
    for (let l of list) {
      if (l > prev) {
        r = (r + sizeTwoArr(s + 1, list, l, searchCost + 1)) % 1000000007;
      } else {
        r = (r + sizeTwoArr(s + 1, list, prev, searchCost)) % 1000000007;
      }
    }
    r = r % 1000000007;
    map.set(key, r);
    return r;
  }
  let result = sizeTwoArr(0, list, -1, 0);
  return result % 1000000007;
};
console.log(numOfArrays(2, 3, 1));
console.log(numOfArrays(5, 2, 3));
console.log(numOfArrays(50, 100, 25));
