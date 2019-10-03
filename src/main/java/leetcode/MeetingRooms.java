package leetcode;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

// https://leetcode.com/problems/meeting-rooms/
public class MeetingRooms {

    /**
     * First sort the meetings by start time and then
     * check start time of current meeting with end time of previous meeting.
     * If start time < end time then the current meeting can't be attended
     * <p>
     * Time: O(N * logN), N is a number of meetings
     * Space: O(1)
     */
    private static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        int prevEndTime = 0;
        for (int[] i : intervals) {
            if (i[0] < prevEndTime) {
                return false;
            }
            prevEndTime = i[1];
        }

        return true;
    }

    public static void main(String... args) {
        Assertions.assertTrue(canAttendMeetings(new int[][]{{1, 4}, {4, 5}, {6, 7}}));
        Assertions.assertFalse(canAttendMeetings(new int[][]{{1, 4}, {2, 5}}));
    }
}
