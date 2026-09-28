class Solution(object):
    def isHappy(self, n):
        while n != 1 and n != 4:
            sum = 0

            while n > 0:
                d = n % 10
                sum += d ** 2
                n = n // 10

            n = sum

        if n == 1:
            return True
        return False