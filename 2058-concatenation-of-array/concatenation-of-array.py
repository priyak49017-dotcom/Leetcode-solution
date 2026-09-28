class Solution(object):
    def getConcatenation(self, nums):
        result=nums
        result.extend(nums)
        return result