package com.problemsolving.leetcode.medium;

import java.util.*;

public class MeetingRoomsOldII {
    // List Implementation
    public int minMeetingRooms1(int[][] intervals) {

        List<List<Integer[]>> rooms = new ArrayList<>();

        Comparator<int[]> byStart = new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        };

        Arrays.sort(intervals, byStart);

        List<Integer[]> lst = new ArrayList<>();
        Integer[] arr = Arrays.stream(intervals[0]).boxed().toArray(Integer[]::new);
        lst.add(arr);
        rooms.add(lst);


        int n = intervals.length;
        boolean addedToExistingRoom = false;

        for (int i = 1; i < n; i++) {
            addedToExistingRoom = false;
            for (int j = 0; j < rooms.size(); j++) {
                arr = Arrays.stream(intervals[i]).boxed().toArray(Integer[]::new);
                if (rooms.get(j).get(rooms.get(j).size() - 1)[1] <= intervals[i][0]) {
                    rooms.get(j).add(arr);
                    addedToExistingRoom = true;
                    break;
                }

            }
            if (!addedToExistingRoom) {
                lst = new ArrayList<>();
                lst.add(arr);
                rooms.add(lst);
            }
        }


        return rooms.size();
    }

    public int minMeetingRooms2(int[][] intervals) {

        List<Integer> rooms = new ArrayList<>();

        Comparator<int[]> byStart = new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        };

        Arrays.sort(intervals, byStart);

        rooms.add(intervals[0][1]);


        int n = intervals.length;
        boolean addedToExistingRoom = false;

        for (int i = 1; i < n; i++) {
            addedToExistingRoom = false;
            for (int j = 0; j < rooms.size(); j++) {
                if (rooms.get(j) <= intervals[i][0]) {
                    rooms.remove(j);
                    rooms.add(intervals[i][1]);
                    addedToExistingRoom = true;
                    break;
                }
            }
            if(!addedToExistingRoom) {
                rooms.add(intervals[i][1]);
            }

        }


        return rooms.size();
    }

    // Priority Queue Implementation
    public int minMeetingRooms3(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // Min heap
        Comparator<Integer> byEnd = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        PriorityQueue<Integer> allocator = new PriorityQueue<>(intervals.length, byEnd);

        Comparator<int[]> byStart = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        };

        Arrays.sort(intervals, byStart);

        // add first meeting
        allocator.add(intervals[0][1]);

        int n = intervals.length;
        for (int i = 1; i < n; i++) {
            if (allocator.peek() <= intervals[i][0]) {
                allocator.poll();
            }
            allocator.add(intervals[i][1]);
        }
        return allocator.size();
    }

    public static void main(String[] args) {
        int[][] intervals1 = {
                {0, 30},
                {5, 10},
                {15, 20}
        }; // expected: 2

        int[][] intervals2 = {
                {7, 10},
                {2, 4},
        }; // expected: 1

        MeetingRoomsOldII meetingRoomsII = new MeetingRoomsOldII();

        System.out.println(meetingRoomsII.minMeetingRooms1(intervals1));
        System.out.println(meetingRoomsII.minMeetingRooms1(intervals2));
    }
}
