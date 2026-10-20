# Greedy Algorithms:
a greedy algorithm constructs a solution one decision at a time. At each step, it chooses an option according to a local rule, commits to it, then apply the same rule for the remaining input.

steps:  
1. define the optimization problem.
2. propose a greedy choice.
3. if the choice can be globally safe, commit to it, else, change to another rule.
4. reduce the remaining subproblem and apply the rule until nothing is left


### examples
[455. Assign Cookies](../easy/455_assign_cookies.py)  
[860. Lemonade Change](../easy/860_lemonade_change.py)  
[452. Minimum Number of Arrows to Burst Balloons](../medium/452_min_arrows_burst_balloons.py)