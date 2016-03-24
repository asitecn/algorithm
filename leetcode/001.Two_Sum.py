class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        map = {}
        for idx, val in enumerate(nums):
            if target-val not in map:
                map[val] = idx
            else:
                return [map[target-val]+1, idx+1]
        return [-1, -1]
