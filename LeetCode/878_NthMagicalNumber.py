class Solution:
    def nthMagicalNumber(self, N, A, B):
        """
        :type N: int
        :type A: int
        :type B: int
        :rtype: int
        """
        quan = 1000000007
        if A > B :
            A , B = B, A
        lcm = A*B/self.gcd(A,B)
        per_block = lcm/A + lcm/B - 1
        
        #N is offset to include lcm's multiples, which are excluded in the begining
        M = int( N + int (N // per_block) ) 
        
        # x is number of multiples of B before N 
        x = int ((M+1)/( (B/A)+1 ))
        
        if M == self.func(x,A,B):
            return (x*B)%quan
        else:
            return ((M-x)*A)%quan

        
    def  func(self,i,a,b):
        return int ( (i*b/a) + i)
        
    def gcd(self,a,b):
        if b % a == 0:
            return a
        else:
            return self.gcd(b%a,a)
