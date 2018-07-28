class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        i = 1
        for x in nums:
            if(target-x in nums[i::]):
                return [i-1,i+nums[i::].index(target-x)]
            else:
                i = i+1
