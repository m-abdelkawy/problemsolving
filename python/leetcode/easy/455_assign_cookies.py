# Problem: 455. Assign Cookies
# Level: Easy
# Tags: Greedy
# Link: https://leetcode.com/problems/assign-cookies/
# Date Solved: 2026.10.18

class Solution:
    def findContentChildren(self, g: list[int], s: list[int]) -> int:
        g.sort()
        s.sort()
        i = j = content = 0 
        while i < len(g) and j < len(s):
            if s[j] >= g[i]:
                content += 1
                i += 1
            j += 1
        return content
            
if __name__ == "__main__":
    g = [1, 2, 3]
    s = [1, 1]
    solver = Solution()
    print(solver.findContentChildren(g=g, s=s))