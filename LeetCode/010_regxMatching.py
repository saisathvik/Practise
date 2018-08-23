class Solution:
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        breaks = {}

        def dp(i,j):
            if (i,j) not in breaks:
                if j == len(p):
                    ans = (i == len(s))
                else:
                    f_m = (i < len(s)) and p[j] in {s[i],"."}
                    if j + 1 < len(p) and p[j + 1] == "*":
                        ans = dp(i, j+2) or (f_m and dp(i+1, j))
                    else:
                        ans = f_m and dp(i+1, j+1)

                breaks[i, j] = ans

            return breaks[i, j]

        return dp(0,0)


