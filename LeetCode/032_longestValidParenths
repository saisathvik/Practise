class Solution:
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        l = []
        for i in range(len(s)):
            if len(l) > 0 and (s[l[-1]] == "(" and s[i] == ")"):
                l.pop()
            else:
                l.append(i)
        print(l)
        if not l:
            return len(s)

        max_len = max(l[0], len(s)-l[-1]-1)
        print(max_len)
        for i in range(len(l)-1):
            length = l[i+1] - l[i] -1
            if max_len < length:
                max_len = length

        return max_len


if __name__ == "__main__":
    print(Solution().longestValidParentheses("(()"))
