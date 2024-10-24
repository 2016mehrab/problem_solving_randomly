const Heap = require('./Heap')
class MaxHeap extends Heap{
    pairIsInCorrectOrder(f,l){
        return this.compare.greaterThan(f,l);
    }
}
module.exports=MaxHeap;