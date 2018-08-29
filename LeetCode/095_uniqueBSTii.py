# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def generateTrees(self, n):
        """
        :type n: int
        :rtype: List[TreeNode]
        """
        mem = {}

        def dfs(start, end):
            if (start, end) in mem.keys():
                return mem[(start, end)]
            if end < start:
                return [None]
            arr = []
            for root_val in range(start, end + 1):
                left_trees = dfs(start, root_val - 1)
                mem[start, root_val-1] = left_trees
                right_trees = dfs(root_val + 1, end)
                mem[root_val+1, end] = right_trees
                for lNode in left_trees:
                    for rNode in right_trees:
                        new = TreeNode(root_val)
                        new.left = lNode
                        new.right = rNode
                        arr.append(new)
            return arr

        res = dfs(1, n)
        return [] if res == [None] else res


if __name__ == "__main__":
    print(Solution().generateTrees(3))
