class Solution:
    def nthMagicalNumber(self, N, A, B):
        """
        :type N: int
        :type A: int
        :type B: int
        :rtype: int
        """
        quan = 1000000007
        lcm = A*B/self.gcd(A,B)
        per_block = lcm/A + lcm/B - 1
        
        M = int( N + int (N // per_block) ) 
        
        lhs = int (( M/( (B/A)+1) ) - 1)
        rhs = int ((M+1)/( (B/A)+1 ))
        
        for x in range(lhs,rhs+1):
            if M == self.func(x,A,B):
                return (x*B)%quan
            elif M < self.func(x+1,A,B):
                return ((M-x)*A)%quan
        
    def  func(self,i,a,b):
        return int ( (i*b/a) + i)
        
    def gcd(self,a,b):
        if a > b:
            a , b = b , a
        if b % a == 0:
            return a
        else:
            return self.gcd(b%a,a)
