# Problem: 860. Lemonade Change
# Level: Easy
# Tags: Greedy
# Link: https://leetcode.com/problems/max-consecutive-ones/
# Date Solved: 2026.10.19

class Solution:
    def lemonadeChange(self, bills: list[int]) -> bool:
        fives = 0
        tens = 0
        for bill in bills:
            if bill == 5: fives += 1
            elif bill == 10:
                if fives == 0: 
                    return False
                fives -= 1
                tens += 1
            elif bill == 20:
                if tens > 0 and fives > 0:
                    tens -= 1
                    fives -= 1
                elif fives >= 3:
                    fives -= 3
                else: 
                    return False
        return True
    
if __name__ == "__main__":
    bills = [5, 5, 10, 10, 20]
    solver = Solution()
    print(solver.lemonadeChange(bills))