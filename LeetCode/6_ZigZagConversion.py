class Solution:
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows == 1:
            return s
        out = ""
        
        for i in range(numRows):
            for j in range(i,len(s),2*(numRows - 1)):
                out = out + s[j]
                if 0 < i < numRows - 1 and j + 2*(numRows - 1 - i) < len(s):
                    out = out + s[j + 2*(numRows -1 - i)]
        
        return out
