class Solution:
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        ans = ""
        str = str.strip()
        if str == "":
            return 0
        if str[0] not in "+-0123456789":
            return 0
        for i in str[1::]:
            if i not in "0123456789":
                break
            else:
                ans = ans + i
        ans = str[0] + ans
        if ans in ["","-","+"]:
            return 0
        ans = int (ans)
        int_min = -2**31
        int_max = 2**31 - 1
        
        if ans < int_min:
            return int_min
        elif ans > int_max:
            return int_max
        else:
            return ans
