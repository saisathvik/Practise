class Solution:
    def isScramble(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: bool
        """
        if s1 == s2:
            return True

        if not self.isAnagram(s1, s2):
            return False
        n = len(s1)
        ans = False

        for i in range(n-1):
            ans = (self.isScramble(s1[0:i+1], s2[0:i+1]) and self.isScramble(s1[i+1:], s2[i+1:])) \
                  or (self.isScramble(s1[0:i+1], s2[n-i-1:]) and self.isScramble(s1[i+1:], s2[0:n-1-i]))
            if ans:
                break

        return ans

    def isAnagram(self, s1, s2):
        dict1, dict2 = [0]*26, [0]*26
        if not (len(s1) == len(s2) and set(s1) == set(s2)):
            return False
        for i in range(len(s1)):
            dict1[ord(s1[i]) - ord('a')] += 1
            dict2[ord(s2[i]) - ord('a')] += 1
        return True if dict1 == dict2 else False
       
       
if __name__ == "__main__":
#    print(Solution().isScramble("great", "rgeat"))
#    print(Solution().isScramble("abcde","caebd"))
    print(Solution().isScramble("abcdefghijklmn", "efghijklmncadb"))
