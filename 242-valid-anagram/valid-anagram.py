class Solution(object):
    def isAnagram(self, s, t):
        if len(s) != len(t):
            return False
        t=sorted(t)
        s=sorted(s)
        if s == t:
            return True
        else:
            return False
        