from typing import List

class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
class Heap:
    def __init__(self, arr =None, key=lambda x:x):
        self.heap=[0]
        self.key =key
        if arr:
            self.heapify(arr)

    def percolate_up(self):
        i=len(self.heap)-1
        while i//2>0 and self.key(self.heap[i])  <  self.key(self.heap[i//2]) :
            self.heap[i],self.heap[i//2] =self.heap[i//2], self.heap[i]
            i=i//2

    def add(self, num):
        self.heap.append(num)
        self.percolate_up()

    def heapify(self, arr):
        self.heap=[0]
        for num in arr:
            self.add(num)
        
    def peek(self):
        if len(self.heap)<=1:
            return None
        return  self.heap[1]

    def poll(self ):
        if len(self.heap)==1:
            return None

        if len(self.heap)==2:
            return self.heap.pop()
        #min
        res= self.heap[1]
        self.heap[1] = self.heap.pop()
        self.percolate_down()
        return res

    def percolate_down(self,idx=1):
        i=idx
        while 2*i < len(self.heap):
            smallest=2*i
            if 2*i+1 < len(self.heap) and self.key(self.heap[2*i+1])  < self.key(self.heap [smallest]) :
                smallest=2*i+1

            if self.key(self.heap[i]) > self.key(self.heap[smallest]) :
                self.heap[i],self.heap[smallest] = self.heap[smallest],self.heap[i]
                i= smallest
            else :
                break


def sort(arr ,start, end, key):
    if end-start+1<=1:
        return 
    left= start
    pivot =key(arr[end])
    for i in range(start, end):
        if key(arr[i]) < pivot:
            arr[i], arr[left] =arr[left],arr[i]
            left+=1
    arr[left], arr[end] =arr[end], arr[left]
    sort(arr, start ,left-1,key)
    sort(arr, left+1,end,key)

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        if len(intervals) ==0:
            return 0
        sort(intervals , 0 , len(intervals) -1 , key= lambda x: x.start )

        pq= Heap(key=lambda x: x.end)

        pq.add(intervals[0])
        for i in range(1,len(intervals)):
            earliest_meeting_end =pq.peek()
            if earliest_meeting_end and intervals[i].start >= earliest_meeting_end.end:
                pq.poll()
                pq.add(intervals[i])
            else:
                pq.add(intervals[i])
        return len(pq.heap)-1

        

intervals = [Interval(0,40), Interval(5,10), Interval(15,20)]
s= Solution()       
s.minMeetingRooms(intervals)
