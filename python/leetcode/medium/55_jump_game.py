# Problem: 55. Jump Game 
# Level: Medium
# Tags: Greedy
# Link: https://leetcode.com/problems/jump-game 
# Date Solved: 2026.10.20

class Solution:
    def canJump(self, nums: list[int]) -> bool:
        farthest_index = 0
        for i in range(len(nums)):
            if farthest_index < i:
                break
            farthest_index = i + nums[i] if i + nums[i] > farthest_index else farthest_index
            if farthest_index >= len(nums) - 1:
                return True
        return False
        
    def canJump2(self, nums: list[int]) -> bool:
        farthest_index = 0
        for i, max_jump in enumerate(nums):
            if i > farthest_index:
                return False
            
            farthest_index = max(i + max_jump, farthest_index)
            
            if farthest_index >= len(nums) - 1:
                return True
        return False

if __name__ == "__main__":
    solver = Solution()
    
    nums = [3,0,8,2,0,0,1]
    print(f"can jump: {solver.canJump(nums)}")
    
    nums = [2,3,1,1,4]
    print(f"can jump: {solver.canJump(nums)}")
    
    nums = [3,2,1,0,4]
    print(f"can jump: {solver.canJump(nums)}")