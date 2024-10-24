export default class Comparator {
  constructor(compareFunction) {
    this.compare = compareFunction || Comparator.defaultCompareFucntion;
  }
  static defaultCompareFucntion(f, l) {
    if (f === l) return 0;
    return f > l ? 1 : -1;
  }
  lessThan(f, l) {
    this.compare(f, l) < 0;
  }
  greaterThan(f, l) {
    this.compare(f, l) > 0;
  }
}
