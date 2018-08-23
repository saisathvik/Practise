class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        sub_string = []
        temp_str = []
        
        for c in s:
            if c not in temp_str:
                temp_str.append(c)
                if len(temp_str) > len(sub_string):
                    sub_string = temp_str
            elif c in temp_str:
                temp_str = temp_str[temp_str.index(c) + 1 ::]
                temp_str.append(c)
                
        return len(sub_string)
