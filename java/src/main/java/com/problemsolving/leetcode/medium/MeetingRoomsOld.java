package com.problemsolving.leetcode.medium;

import java.util.Arrays;

public class MeetingRoomsOld {
    class Meeting implements Comparable<Meeting>{
        private int start;
        private int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        @Override
        public int compareTo(Meeting other) {
            return Integer.compare(this.getStart(), other.getStart());
        }
    }
    public boolean canAttendAllMeetings(int[][] intervals) {
        int len = intervals.length;
        Meeting[] meetings = new Meeting[len];
        for (int i = 0; i < len; i++) {
            meetings[i] = new Meeting(intervals[i][0], intervals[i][1]);
        }

        Arrays.sort(meetings);

        for (int i = 0; i < len - 1; i++) {
            if(meetings[i].getEnd() > meetings[i+1].getStart()){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] intervals1 = {
                {0, 30},
                {5, 10},
                {15, 20}
        }; // expected: false

        int[][] intervals2 = {
                {7,10},
                {2,4},
        }; // expected: true

        MeetingRoomsOld meetingRooms = new MeetingRoomsOld();

        System.out.println(meetingRooms.canAttendAllMeetings(intervals1));
        System.out.println(meetingRooms.canAttendAllMeetings(intervals2));
    }
}
