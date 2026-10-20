# Problem: 452. Minimum Number of Arrows to Burst Balloons
# Level: Medium
# Tags: Greedy
# Link: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons
# Date Solved: 2026.10.19

class Solution:
    def eraseOverlapIntervals(self, intervals: list[list[int]]) -> int:
        sorted_intervals = sorted(intervals, key=lambda interval: interval[-1])
        prev = count = 0
        st = 0
        end = 1
        for current in range(1, len(intervals)):
            if sorted_intervals[current][st] < sorted_intervals[prev][end]: #overlap
                # overlap: renmove current (remove the interval that ends earlier)
                count += 1
            else:
                prev = current
        return count
    
if __name__ == "__main__":
    intervals = [[1,2],[2,3],[3,4],[1,3]]
    solver = Solution()
    assert(solver.eraseOverlapIntervals(intervals=intervals)) == 1