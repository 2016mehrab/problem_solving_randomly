class Solution:

    def countBadPairs(self, nums: List[int]) -> int:
        bad_pairs= 0
        nums_seen = {}
        for i in range(len(nums)):
            nums[i] = nums[i] - i

        nums_seen[nums[0]] = 1
        for i in range ( 1, len(nums)):
            bad_pairs += i - nums_seen.get( nums[i],0)
            nums_seen[nums[i]] = nums_seen.get(nums[i], 0) + 1
        return bad_pairs







