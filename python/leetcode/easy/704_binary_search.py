# Problem: 704. Binary Search
# Level: Easy
# Tags: Array, Binary Search
# Link: https://leetcode.com/problems/binary-search/description/

class Solution:
    def search(self, nums: list[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        return self.binarySearchRecursive(nums, left, right, target)
    
    def binarySearchIterative(self, nums: list[int], left: int, right: int, target: int) -> int:
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return mid
            if nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return -1

    
    def binarySearchRecursive(self, nums: list[int], left: int, right: int, target: int) -> int:
        if left > right:
            return -1        
        mid = left + (right - left) // 2
        if target == nums[mid]:
            return mid
        elif target < nums[mid]:
            return self.binarySearchRecursive(nums, left, mid - 1, target)
        else:
            return self.binarySearchRecursive(nums, mid + 1, right, target)
    
    
def main() -> None:
    solution = Solution()
    test_cases = [
        ([-1, 0, 3, 5, 9, 12], 9, 4),
        ([-1, 0, 3, 5, 9, 12], 2, -1),
        ([], 5, -1),
    ]

    for nums, target, expected in test_cases:
        assert solution.search(nums, target) == expected

    print("All tests passed.")


if __name__ == "__main__":
    main()