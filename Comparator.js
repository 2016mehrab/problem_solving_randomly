class Comparator {
  constructor(compareFunction) {
    this.compare = compareFunction || Comparator.defaultCompareFunction;
  }
  static defaultCompareFunction(f, l) {
    if (f === l) return 0;
    return f > l ? 1 : -1;
  }
  lessThan(f, l) {
    return this.compare(f, l) < 0;
  }
  greaterThan(f, l) {
    return this.compare(f, l) > 0;
  }
}

module.exports= Comparator