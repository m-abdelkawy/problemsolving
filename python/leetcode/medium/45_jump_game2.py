# Problem: 45. Jump Game II
# Level: Medium
# Tags: Greedy
# Link: https://leetcode.com/problems/jump-game-ii
# Date Solved: 2026.10.20

class Solution:
    def jump(self, nums: list[int]) -> int:
        jumps = 0
        farthest = 0
        current_end = 0
        
        for i in range(len(nums) - 1):
            farthest = max(farthest, i + nums[i])
            
            # examine between i and farthest to check new farthest
            if i == current_end:
                # update current end to farthest
                current_end = farthest
                jumps += 1
        return jumps
                    
    
if __name__ == "__main__":
    solver = Solution()
    nums = [2,3,1,1,4] 
    print(solver.jump(nums))