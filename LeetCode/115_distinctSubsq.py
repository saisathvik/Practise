class Solution:
    def numDistinct(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: int
        """
        m, n = len(s), len(t)
        mem = [0]*(n+1)
        mem[0] = 1
        for i in range(1, m+1):
            for j in range(n, 0, -1):
                if s[i-1] == t[j-1]:
                    mem[j] += mem[j-1]

        return mem[n]


if __name__ == "__main__":
    s, t = ["rabbbit","babgbag"], ["rabbit", "bag"]
    for i in range(len(s)):
        print(Solution().numDistinct(s[i], t[i]))
