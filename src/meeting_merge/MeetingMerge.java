package meeting_merge;

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
        return m1.startTime - m2.startTime;
      }
    });
    return meetings;
  }

  public static void main(String[] args) {
    Meeting[] meetings = new Meeting[] {
            new Meeting(0,1),
            new Meeting(3,5),
            new Meeting(4,8),
            new Meeting(10,12),
            new Meeting(9,10),
    };
    sort(meetings);
    for(int i = 0; i < meetings.length; i++) {
      System.out.println(meetings[i]);
    }
  }
}
