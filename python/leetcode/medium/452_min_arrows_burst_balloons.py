# Problem: 452. Minimum Number of Arrows to Burst Balloons
# Level: Medium
# Tags: Greedy
# Link: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons
# Date Solved: 2026.10.19

class Solution:
    def findMinArrowShots(self, points: list[list[int]]) -> int:
        arrows = 0
        sorted_pts = sorted(points, key=lambda point: point[-1])
        arrow_pos = None
        for start, end in sorted_pts:
            if arrow_pos is None or start > arrow_pos:
                arrow_pos = end
                arrows += 1
        return arrows
             
    
if __name__ == "__main__":
    solver = Solution()
    points = [[10,16],[2,8],[1,6],[7,12]]
    print(solver.findMinArrowShots(points=points)) 
    assert solver.findMinArrowShots(points=points) == 2