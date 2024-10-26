class Heap {
  constructor(compareFunction, heap = []) {
    this.compare = compareFunction || Heap.defaultCompareFunction;
    this.container = [];
    heap.forEach((e) => this.add(e));
  }
  static defaultCompareFunction(f, l) {
    if (f === l) return 0;
    return f > l ? 1 : -1;
  }

  size() {
    return this.container.length;
  }

  isEmpty() {
    return this.container.length < 1;
  }
  getLeftChildIndex(parentIndex) {
    return parentIndex * 2 + 1;
  }
  getRightChildIndex(parentIndex) {
    return parentIndex * 2 + 2;
  }
  getParentIndex(childIndex) {
    return Math.floor((childIndex - 1) / 2);
  }
  hasParent(childIndex) {
    return this.getParentIndex(childIndex) >= 0;
  }
  hasLeftChild(parentIndex) {
    return this.getLeftChildIndex(parentIndex) <= this.container.length - 1;
  }
  hasRightChild(parentIndex) {
    return this.getRightChildIndex(parentIndex) <= this.container.length - 1;
  }

  swap(j, k) {
    const tmp = this.container[j];
    this.container[j] = this.container[k];
    this.container[k] = tmp;
  }
  peek() {
    if (this.container.length === 0) return null;
    return this.container[0];
  }
  leftChild(parentIndex) {
    return this.container[this.getLeftChildIndex(parentIndex)];
  }
  rightChild(parentIndex) {
    return this.container[this.getRightChildIndex(parentIndex)];
  }
  parent(childIndex) {
    return this.container[this.getParentIndex(childIndex)];
  }

  swim() {
    let current = this.container.length - 1;
    while (
      this.hasParent(current) &&
      !this.pairIsInCorrectOrder(this.parent(current), this.container[current])
    ) {
      this.swap(current, this.getParentIndex(current));
      current = this.getParentIndex(current);
    }
  }

  sink() {
    let current = 0;

    while (this.hasLeftChild(current)) {
      let comparisonIndex = this.getLeftChildIndex(current);

      if (
        this.hasRightChild(current) &&
        !this.pairIsInCorrectOrder(
          this.leftChild(current),
          this.rightChild(current)
        )
      ) {
        comparisonIndex = this.getRightChildIndex(current);
      }

      if (
        this.pairIsInCorrectOrder(
          this.container[current],
          this.container[comparisonIndex]
        )
      ) {
        break;
      }

      this.swap(current, comparisonIndex);
      current = comparisonIndex;
    }
  }

  pop() {
    if (this.container.length === 0) {
      return null;
    }
    if (this.container.length === 1) {
      return this.container.pop();
    }
    let tmp = this.container[0];
    this.container[0] = this.container.pop();
    this.sink();
    return tmp;
  }

  add(item) {
    this.container.push(item);
    this.swim();
    return this;
  }
  pairIsInCorrectOrder(f, l) {
    return this.compare(f, l) < 0;
  }
}

/**
 *
 * @param {string[]} words
 * @param {number} k
 * @return {string[]}
 */

var topKFrequent = function (words, k) {
  let map = new Map();
  let q = new Heap((f, l) => {
    if (f[0] === l[0]) {
      if (f[1] > l[1]) {
        return -1;
      } else return 1;
    } else {
      let r = f[0] > l[0] ? 1 : -1;
      return r;
    }
  });
  words.forEach((e) => {
    if (!map.has(e)) {
      map.set(e, 0);
    }
    map.set(e, map.get(e) + 1);
  });
  for (const [key, val] of map.entries()) {
    q.add([val, key]);
    if (q.size() > k) {
      q.pop();
    }
  }
  let result = [];
  while (!q.isEmpty()) {
    result.push(q.pop()[1]);
  }
  result.reverse();
  
};

topKFrequent(
  ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"],
  4
);
topKFrequent(["i", "love", "leetcode", "i", "love", "coding"], 3);
topKFrequent(["i", "love", "leetcode", "i", "love", "coding"], 2);
