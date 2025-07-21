# Grokking Algorithms - Chapter 1 Introduction to Algorithms

## Exercise 1.3
**Question:**
You have a name, and you want to find the person's phone number in the phone book.

**Answer:**
since the phone book is sorted alphabetically, we can use **Binary Search** to find the **Time Complexity:** `O(log n)`

## Exercise 1.4
**Question:**
You have a phone number, and you want to find the person's name in the phone book.  
(Hint: You'll have to search through the whole book!)

**Answer:**
**Time Complexity:** `O(n)`, assuming the phone book is sorted by name alphabetically

## Exercise 1.5
**Question:**
You want to read the numbers of every person in the phone book.

**Answer:**
**Time Complexity:** `O(n)`, visiting names one by one

## Exercise 1.6
**Question:**
You want to read the numbers of every person in the phone book.

**Answer:**
**Time Complexity:** `O(log n + k)`, **Binary search** can be used to find the starting point to find the names starting with a certain letter, then going through them one by one (k times assuming their count is k)

**Mohammed Abdelkawy**