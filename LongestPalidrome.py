class Solution:
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        max_pal = ""
        if len(s) == 0:
            return s
        if s == s[-1::-1]:
            return s
        for i in range(len(s)):
            for j in range(len(s)-1,i,-1):
                if s[i] == s[j]:
                    if s[i:j+1] == s[i:j+1][-1::-1]:
                        if j - i + 1 > len(max_pal):
                            max_pal = s[i:j+1]
        if max_pal == "":
            return s[0]
        return max_pal
