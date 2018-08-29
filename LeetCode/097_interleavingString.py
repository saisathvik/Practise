class Solution:
    def isInterleave(self, s1, s2, s3):
        """
        :type s1: str
        :type s2: str
        :type s3: str
        :rtype: bool
        """
        if not len(s1) + len(s2) == len(s3):
            return False

        mem = {}

        def isInterleaveAfterChecks(s1, s2, s3):

            if not s1 or not s2:
                return True if s1 + s2 == s3 else False

            if (s1, s2) in mem.keys():
                return mem[(s1, s2)]

            if s3[0] == s1[0]:
                if isInterleaveAfterChecks(s1[1:], s2, s3[1:]):
                    mem[(s1, s2)] = mem[(s2, s1)] = True
                    return True
                else:
                    mem[(s1, s2)] = mem[(s2, s1)] = False

            if s3[0] == s2[0]:
                if isInterleaveAfterChecks(s1, s2[1:], s3[1:]):
                    mem[(s1, s2)] = mem[(s2, s1)] = True
                    return True
                else:
                    mem[(s1, s2)] = mem[(s2, s1)] = False

            return False

        return isInterleaveAfterChecks(s1, s2, s3)



if __name__ == "__main__":
    s1, s2, s3 = "aabcc", "dbbca", "aadbbcbcac"
    print(Solution().isInterleave(s1, s2, s3))
    s1, s2, s3 = "aabcc", "dbbca", "aadbbbaccc"
    print(Solution().isInterleave(s1, s2, s3))
