class Solution(object):
    def findPeakElement(self, nums):
        s=sorted(nums)
        tar=s[-1]
        for i in range(len(nums)):
            if nums[i] == tar:
                max=i
                return i
            i+=1
        return max

        
        