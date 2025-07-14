from typing import List


class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end

def sort(arr,start, end, key):
    if end-start+1 <=1:
        return 
    pivot = key(arr[end])
    left= start
    for curr in range (start, end):
        if key(arr[curr]) < pivot : 
            arr[left], arr[curr] = arr[curr], arr[left]
            left+=1

    #left is sorted 
    arr[left],arr[end] = arr[end], arr[left]
    sort(arr,start, left-1, key)
    sort(arr,left+1, end, key)

class Solution:
    def canAttendMeetings(self, intervals: List[Interval]) -> bool:
        if len(intervals)==0:
            return True
        # sort
        sort(intervals, 0 , len(intervals)-1, key=lambda x:x.start)
        print(f"interval after sorting: {intervals}")
        prevEnd= intervals[0].end
        for idx,interval in enumerate(intervals):
            if idx==0:
                continue
            start, end =interval.start, interval.end
        # compare adjacent two intervals
            if prevEnd > start:
                return False
            prevEnd= end
        # if adjacent meetings are fine then obviously, the further 
        # ones would also be fine
        return True
s=Solution()
intervals1=[Interval(5,8),Interval(9,15)]
s.canAttendMeetings(intervals1)
