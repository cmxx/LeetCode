package problems;

import java.util.*;

import supporting.Interval;

public class MeetingRooms_252 {
	// # 252 Meeting Rooms
	// Passed.

	// My solution.
	// Status: Failed. Error: Memory Limit Exceeded.
	public boolean canAttendMeetings(Interval[] intervals) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < intervals.length; i++) {
			int s = intervals[i].start;
			int e = intervals[i].end;
			for (int j = s; j < e; j++) {
				boolean checker = set.add(j);
				if (checker == false)
					return false;
			}

		}
		return true;
	}

	/**
	 * Status: passed. 4ms 95.29% Explanation: If all time intervals has no
	 * conflicts, After sorting all time intervals from earliest to latest, the
	 * end time of interval-1 should be smaller than the start time of
	 * interval-2. In the other word, interval-2's start time should be larger
	 * than interval-2's end time.
	 * 
	 * @param intervals
	 * @return
	 */
	public boolean op(Interval[] intervals) {
		if (intervals == null)
			return true;
		int[] s = new int[intervals.length]; // Store all starting time
		int[] e = new int[intervals.length]; // Store all ending time
		for (int i = 0; i < intervals.length; i++) {
			s[i] = intervals[i].start;
			e[i] = intervals[i].end;
		}
		Arrays.sort(s);
		Arrays.sort(e);
		for (int j = 1; j < s.length; j++) {
			if (s[j] < e[j - 1])
				return false;
		}
		return true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MeetingRooms_252 t = new MeetingRooms_252();
		Interval t1 = new Interval(0, 5);
		Interval t2 = new Interval(5, 8);
		Interval t3 = new Interval(7, 9);
		Interval t4 = new Interval(11, 15);

		Interval[] l1 = { t1, t2, t4 }; // This should be True
		Interval[] l2 = { t1, t2, t3 }; // This should be False

		System.out.println(t.op(l1));
		System.out.println(t.op(l2));
	}

}
