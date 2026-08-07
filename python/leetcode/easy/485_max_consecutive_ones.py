# Problem: 485. Max Consecutive Ones
# Level: Easy
# Tags: List
# Link: https://leetcode.com/problems/max-consecutive-ones/
# Date Solved: 2026.08.07

class solution:
    def findMaxConsecutiveOnes1(self, nums: list[int]) -> int:
        count = 0
        res = 0
        for num in nums:
            if num == 1:
                count += 1
            else:
                res = max(res, count)
                count = 0
        res = max(res, count)
        return res

    def findMaxConsecutiveOnes2(self, nums: list[int]) -> int:
        count = 0
        res = 0
        for num in nums:
            if num == 1:
                count += 1
                res = max(res, count)
            else:
                count = 0
        return res

    def findMaxConsecutiveOnes3(self, nums: list[int]) -> int:
        count = res = 0
        for num in nums:
            count = count + 1 if num else 0
            res = max(res, count)
        return res

    def findMaxConsecutiveOnes4(self, nums: list[int]) -> int:
        return max(map(len, ''.join(map(str, nums)).split('0')))

if __name__ == '__main__':
    solution = solution()
    print(solution.findMaxConsecutiveOnes4(nums=[1, 1, 0, 1, 1, 1]))