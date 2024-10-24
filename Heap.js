const Comparator = require("./Comparator");
class Heap {
  constructor(compareFunction) {
    if (new.target === Heap) {
      throw new TypeError("Cannot create instane directly");
    }
    this.container = [];
    this.compare = new Comparator(compareFunction);
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
      !this.pairIsInCorrectOrder(
        this.parent(current),
        this.container[current]
      )
    ) {
      this.swap(current, this.getParentIndex(current));
      current = this.getParentIndex(current);
    }
  }
  sink() {
    let current = this.container[0];
    let comparisonIndex = null;

    while (this.hasLeftChild(current) || this.hasRightChild(current)) {
      // find the ultimate from left and right
      if (
        this.hasLeftChild(current) &&
        this.pairIsInCorrectOrder(
          this.leftChild(current),
          this.rightChild(current)
        )
      ) {
        comparisonIndex = this.getLeftChildIndex(current);
      } else {
        comparisonIndex = this.getRightChildIndex(current);
      }
      // comparing the ultimate with curr
      if (
        this.pairIsInCorrectOrder(
          this.container[current],
          this.container[comparisonIndex]
        )
      ) {
        break;
      } else this.swap(current, comparisonIndex);
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
    throw new Error("You have to override heap pair comparison method");
  }
}

module.exports = Heap;
