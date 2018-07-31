class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        m,n = len(nums1),len(nums2)
        i,j = 0,0
        l = []

        if m == 0:
            l = nums2
        if  n == 0:
            l = nums1

        while i != m and j != n:
            if nums1[i] < nums2[j]:
                l.append(nums1[i])
                i = i + 1
            else:
                l.append(nums2[j])
                j = j + 1

            if i == m:
                l = l+ nums2[j::]
            elif j == n:
                l = l + nums1[i::]

        mid = (m + n) // 2
        if (m+n)%2 == 0:
            return (l[mid]+l[mid-1])/2
        else:
            return l[mid]
