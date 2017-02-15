package meeting_merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by swu on 14/02/2017.
 */
public class MeetingMerge {
  public static Meeting[] sort(Meeting[] meetings) {
    Arrays.sort(meetings, new Comparator<Meeting>() {
      @Override
      public int compare(Meeting m1, Meeting m2) {
        /**
         * < 0 : (m1 < m2)
         * = 0 : (m1 = m2)
         */

        return m1.startTime - m2.startTime;
      }
    });
    return meetings;
  }

  public static Meeting[] merge(Meeting[] meetings) {
    sort(meetings);
    ArrayList<Meeting> result = new ArrayList<>();
    if (meetings.length < 1) return new Meeting[0];
    Meeting current_range = meetings[0];

    for (int i = 0; i < meetings.length; i++) {
      Meeting current = meetings[i];
      if (current.startTime <= current_range.endTime) {
        current_range.endTime = Math.max(current.endTime, current_range.endTime);
      } else {
        result.add(current_range);
        current_range = current;
      }
    }
    result.add(current_range);
    return result.toArray(new Meeting[result.size()]);
  }

  public static void main(String[] args) {
    Meeting[] meetings = new Meeting[] {
            new Meeting(1,2),
            new Meeting(2,3)
    };

    Meeting[] results = merge(meetings);
    for(int i = 0; i < results.length; i++) {
      System.out.println(results[i]);
    }
  }
}
