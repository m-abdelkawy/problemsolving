package com.problemsolving.leetcode.easy;

/**
 * 278. First Bad Version
 * https://leetcode.com/problems/first-bad-version/?envType=study-plan&id=algorithm-i
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 10.12.2022
 */
public class FirstBadVersion {
    /**
     * Time Complextiy: O(log n)
     * Space Complexity: O(1)
     * @param n
     * @return
     */
    public int firstBadVersion1(int n) {
        int lo = 1, hi = n;
        int firstBadVersion = -1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(isBadVersion(mid)){
                firstBadVersion = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return firstBadVersion;
    }

    public int firstBadVersion2(int n) {
        int lo = 0, hi = n;
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            if(isBadVersion(mid)){
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean isBadVersion(int version) {
        return true;
    }
}
