# Grokking Algorithms - Chapter 2 Selection Sort

## Exercise 2.2
**Question:**
Suppose you're building an app to keep track of your finances. 
Every day, you write down everything you spent money on. 
At the end of the month, you review your expenses and sum up how much you spent. 
So, you have lots of inserts and a few reads. Should you use an array or a list

**Answer:**
Linked lists are a better option in this scenario since they are better in insertion `O(1)` vs `O(n)`.

## Exercise 2.2
**Question:**
Suppose you’re building an app for restaurants to take customer orders. 
Your app needs to store a list of orders. Servers keep adding orders to this list, 
and chefs take orders off the list and make them. 
It’s an order queue: servers add orders to the back of the queue, 
and the chef takes the first order off the queue and cooks it.
Would you use an array or a linked list to implement this queue? 
(Hint: Linked lists are good for inserts/deletes, and arrays are good for random access. 
Which one are you going to be doing here?)

**Answer:**
Linked Lists are a better option, since we are doing more insertions and deletions in this scenario, 
which take `O(1)` time, compared to `O(n)` for arrays that require shifting elements.
The chef is always taking (i.e deleting) the first element in the list, so random access is not actually needed

## Exercise 2.3
**Question:**
Let’s run a thought experiment. Suppose Facebook keeps a list of usernames. 
When someone tries to log in to Facebook, a search is done for their username. 
If their name is in the list of usernames, they can log in. 
People log in to Facebook pretty often, so there are a lot of searches through this list of usernames. 
Suppose Facebook uses binary search to search the list. 
Binary search needs random access—you need to be able to get to the middle of the list of usernames instantly. 
Knowing this, would you implement the list as an array or a linked list?

**Answer:**
An Array is better since random access is needed which takes `O(1)` time, compared to the linked list when we 
need to access the element in the middle, we will have to traverse the list from the beginning, which
takes `O(n)` time

## Exercise 2.4
**Question:**
People sign up for Facebook pretty often, too. 
Suppose you decided to use an array to store the list of users. 
What are the downsides of an array for inserts? 
In particular, suppose you’re using binary search to search for logins. 
What happens when you add new users to an array?

**Answer:**
adding new users will require shifting all the elements in the array to position the element in the right
position to keep the order of the elements and this operation takes `O(n)` time
and when the size exceeds the allocated slots in the array we will need to copy all the elements to
a new position in the memory to allocate bigger space

## Exercise 2.5
**Question:**
In reality, Facebook uses neither an array nor a linked list to store user information. 
Let’s consider a hybrid data structure: an array of linked lists. You have an array with 26 slots. 
Each slot points to a linked list. 
For example, the first slot in the array points to a linked list containing all the usernames starting with a. 
The second slot points to a linked list containing all the usernames starting with b, and so on.

Suppose Adit B signs up for Facebook, and you want to add them to the list. 
You go to slot 1 in the array, go to the linked list for slot 1, and add Adit B at the end. 
Now, suppose you want to search for Zakhir H. You go to slot 26, which points to a linked list of all the Z names. 
Then you search through that list to find Zakhir H.

Compare this hybrid data structure to arrays and linked lists. 
Is it slower or faster than each for searching and inserting? 
You don’t have to give Big O run times, just whether the new data structure would be faster or slower.

**Answer:**
***For searching*** a sorted array would be faster to use binary search on , because we still have to traverse
a linked list one by one to find the name
yet faster than using a linked list as we eliminated all names that do not start with the z letter, which
means we are only traversing the last list that has names starting with z

***For inserting*** the hybrid approach is faster than the array since no element shifting is require, 
and almost the same as the linked list, just one additional step to determine which slot in 
the array to insert the name in its linked list, yet both have `O(1)` run time

**Mohammed Abdelkawy**