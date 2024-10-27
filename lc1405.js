/**
 * @param {number} a
 * @param {number} b
 * @param {number} c
 * @return {string}
 */

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
      // Determine the child to compare with
      let comparisonIndex = this.getLeftChildIndex(current);

      // If there's a right child, choose the child in correct order
      if (
        this.hasRightChild(current) &&
        !this.pairIsInCorrectOrder(
          this.leftChild(current),
          this.rightChild(current)
        )
      ) {
        comparisonIndex = this.getRightChildIndex(current);
      }

      // Stop sinking if the current node is already in the correct order
      if (
        this.pairIsInCorrectOrder(
          this.container[current],
          this.container[comparisonIndex]
        )
      ) {
        break;
      }

      // Swap and move to the next level down
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

// [1, 'a'], [3, 'c']
var longestDiverseString = function (a, b, c) {
  const q = new Heap((f, l) => (f[0] < l[0] ? 1 : -1));
  if (a === 0 && b === 0 && c === 0) return "";
  a ? q.add([a, "a"]) : null;
  b ? q.add([b, "b"]) : null;
  c ? q.add([c, "c"]) : null;

  let result = "";
  while (!q.isEmpty()) {
    let first = q.pop();
    if (
      result.length >= 2 &&
      result[result.length - 1] === result[result.length - 2] &&
      first[1] === result[result.length - 1]
    ) {
      if (q.isEmpty()) break;
      let second = q.pop();
      result += second[1];
      second[0] -= 1;
      if (second[0] > 0) {
        q.add(second);
      }
    } else {
      result += first[1];
      first[0] -= 1;
    }
    if (first[0] > 0) {
      q.add(first);
    }
  }
  console.table(result);
  return result;
};
longestDiverseString(1, 1, 7);
longestDiverseString(7, 1, 0);
