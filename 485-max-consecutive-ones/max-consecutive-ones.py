class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        count=0
        maxcount=0
        for i in nums:
            if i == 1:
                count += 1
                maxcount=max(maxcount,count)
            else:
                count=0
        return maxcount
        
       
        