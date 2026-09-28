class Solution(object):
    def maximumWealth(self, accounts):
        maxi=0

        for row in accounts:
            maxi=max(maxi,sum(row))
        return maxi
        

        