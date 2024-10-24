import Heap from "./Heap";
export default class MaxHeap extends Heap{
    pairIsInCorrectOrder(f,l){
        return this.compare.greaterThan(f,l);
    }
}