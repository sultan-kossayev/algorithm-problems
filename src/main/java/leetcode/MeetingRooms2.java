package leetcode;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/meeting-rooms-ii/
public class MeetingRooms2 {

    /**
     * First sort the meetings by start time and then
     * find a room for all the meetings by looking for a room that is empty now.
     * In order not to iterate through all the rooms and check whether their empty
     * have a priority queue which will contains all rooms booked so far and it will return
     * a room that will get free earliest
     * <p>
     * Time: O(N * logN), N is a number of meetings
     * Space: O(N) because of the queue
     */
    private static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        for (int i = 0; i < intervals.length; i++) {
            Integer r = rooms.peek(); // end time
            if (r != null && r <= intervals[i][0]) {  // end time <= start time
                rooms.poll();
            }

            rooms.add(intervals[i][1]); // putting end time to the queue
        }

        return rooms.size();
    }

    public static void main(String... args) {
        Assertions.assertEquals(minMeetingRooms(new int[][]{{1, 3}, {2, 3}, {4, 5}}), 2);
    }
}
