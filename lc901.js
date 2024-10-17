var StockSpanner = function () {
  this.stocks = [];
  this.stack = [];
};

/**
 * @param {number} price
 * @return {number}
 */
StockSpanner.prototype.next = function (price) {
  this.stocks.push(price);
  let span = 1;
  while (
    this.stack.length !== 0 &&
    this.stack[this.stack.length - 1][0] <= price
  ) {
    let tmp = this.stack.pop();
    span += tmp[1];
  }
  this.stack.push([price, span]);
  return this.stack[this.stack.length - 1][1];
};

var ins = new StockSpanner();
console.log(ins.next(28));
console.log(ins.next(14));
console.log(ins.next(28));
console.log(ins.next(35));
console.log(ins.next(46));
console.log(ins.next(53));
console.log(ins.next(66));
console.log(ins.next(80));
console.log(ins.next(87));
console.log(ins.next(88));
