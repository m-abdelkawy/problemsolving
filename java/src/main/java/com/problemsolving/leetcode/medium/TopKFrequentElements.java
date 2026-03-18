package com.problemsolving.leetcode.medium;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 * Link: https://leetcode.com/problems/top-k-frequent-elements
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 03.18.2025
 */
public class TopKFrequentElements {

    /**
     * by sorting
     * Complexity:
     *      Time: O(n log n) because of sorting
     *      Space: O(n) - as we created a map with the same size of the input in the worst case
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent1(int[] nums, int k) {
        // 1. building the frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num: nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // 2. sort by frequency descending
        List<Integer> keys = new ArrayList<>(frequencyMap.keySet());
        keys.sort((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        return keys.subList(0, k).stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Using min-heap of size k, the heap stores whole entries
     * Complexity:
     *       Time: O(n log k) because each insert in the heap of size k costs log k
     *       Space: O(n + k) map plus heap storage
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent2(int[] nums, int k) {
        // 1. building the frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num: nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // 2. set up a min heap and keep the size k
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparing(Map.Entry::getValue));
        for(Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()){
            minHeap.offer(entry);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.stream().mapToInt(Map.Entry::getKey).toArray();
    }

    /**
     * Using min-heap of size k, the heap stores keys only
     * Complexity:
     *       Time: O(n log k) because each insert in the heap of size k costs log k
     *       Space: O(n + k) map plus heap storage
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent3(int[] nums, int k) {
        // 1. building the frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num: nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // 2. set up a min heap and keep the size k
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(Comparator.comparingInt(frequencyMap::get));
        for(Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()){
            minHeap.offer(entry.getKey());
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Using Bucket sort approach
     * Complexity:
     *       Time: O(n) no sorting
     *       Space: O(n) map and bucket sizes proportional with n
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent4(int[] nums, int k) {
        // 1. building the frequency map <number, frequency>
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num: nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // 2. build n + 1 buckets as the max frequency is n (the bucket is basically an array of lists)
        List<Integer>[] bucket = new List[nums.length + 1];
        for(int key: frequencyMap.keySet()){
            int f =  frequencyMap.get(key);
            if(bucket[f] == null){
                bucket[f] = new ArrayList<>();
            }
            bucket[f].add(key);
        }

        int[] res = new int[k];
        int idx_res = 0;
        for(int i = bucket.length - 1; i >= 0 && idx_res < k; i--){
            if(bucket[i] != null){
                for(int num: bucket[i]){
                    res[idx_res++] = num;
                    if(idx_res == k) break;
                }
            }
        }
        return res;
    }
}
