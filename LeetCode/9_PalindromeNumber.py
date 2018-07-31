class Solution:
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        x_str = str(x)
        
        if x_str == x_str[-1::-1]:
            return True
        return False
