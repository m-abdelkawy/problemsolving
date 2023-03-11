package com.problemsolving.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * 706. Design HashMap
 * Link: https://leetcode.com/problems/design-hashmap/
 *
 * @author m-abdelkawy
 * @version 1.0.0
 * @since 22.02.2023
 */

class Pair<U, V> {
    public U key;
    public V value;

    public Pair(U key, V value) {
        this.key = key;
        this.value = value;
    }
}

class Bucket {
    private List<Pair<Integer, Integer>> bucket;

    public Bucket() {
        this.bucket = new LinkedList<>();
    }

    public Integer get(Integer key) {
        for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.key.equals(key)) {
                return pair.value;
            }
        }
        return -1;
    }

    public void update(Integer key, Integer value) {
        boolean found = false;
        for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.key.equals(key)) {
                pair.value = value;
                found = true;
                break;
            }
        }

        if (!found) {
            this.bucket.add(new Pair<>(key, value));
        }
    }

    public void remove(Integer key) {
        this.bucket.removeIf(pair -> pair.key.equals(key));
    }
}

public class MyHashMap {
    private int key_space;
    private List<Bucket> hash_table;

    public MyHashMap() {
        this.key_space = 2069;
        this.hash_table = new LinkedList<>();

        for (int i = 0; i < this.key_space; i++) {
            hash_table.add(new Bucket());
        }
    }

    public void put(int key, int value) {
        int hash_key = key % this.key_space;
        this.hash_table.get(hash_key).update(key, value);
    }

    public int get(int key) {
        int hash_key = key % this.key_space;
        return this.hash_table.get(hash_key).get(key);
    }

    public void remove(int key) {
        int hash_key = key% this.key_space;
        this.hash_table.get(hash_key).remove(key);
    }
}
