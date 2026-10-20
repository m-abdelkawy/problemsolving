# Problem: 452. Minimum Number of Arrows to Burst Balloons
# Level: Medium
# Tags: Greedy
# Link: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons
# Date Solved: 2026.10.19

class Solution:
    def numRescueBoats(self, people: list[int], limit: int) -> int:
        people.sort()
        
        left, right = 0, len(people) - 1
        boats = 0
        
        while left <= right:
            if people[left] + people[right] <= limit:
                left += 1
            right -= 1
            boats += 1
        return boats


if __name__ == "__main__":
    people = [3,8,7,1,4]
    solver = Solution()
    print(solver.numRescueBoats(people, 9))
    assert solver.numRescueBoats(people, 9) == 3