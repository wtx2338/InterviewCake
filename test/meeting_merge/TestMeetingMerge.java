package meeting_merge;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by swu on 15/02/2017.
 */
public class TestMeetingMerge extends TestCase {
  @Test
  public void testNormalCase() {
    Meeting[] meetings = new Meeting[] {
            new Meeting(0, 1),
            new Meeting(3, 5),
            new Meeting(4, 8),
            new Meeting(10, 12),
            new Meeting(9, 10)
    };

    Meeting[] results = MeetingMerge.merge(meetings);
    assert results.length == 3;
    assert results[0].equals(new Meeting(0, 1));
    assert results[1].equals(new Meeting(3, 8));
    assert results[2].equals(new Meeting(9, 12));
  }

  @Test
  public void testHasEqualsMeeting() {
    Meeting[] meetings = new Meeting[] {
            new Meeting(1, 2),
            new Meeting(2, 3)
    };

    Meeting[] results = MeetingMerge.merge(meetings);
    assert results[0].equals(new Meeting(1, 3));
  }
  @Test
  public void testInsideAnotherMeeting() {
    Meeting[] meetings = new Meeting[] {
            new Meeting(1, 5),
            new Meeting(2, 3)
    };

    Meeting[] results = MeetingMerge.merge(meetings);
    assert results[0].equals(new Meeting(1, 5));
  }

  @Test
  public void testMultipleInsideAnotherMeeting() {
    Meeting[] meetings = new Meeting[] {
            new Meeting(1, 10),
            new Meeting(2, 6),
            new Meeting(3, 5),
            new Meeting(7, 9),
    };

    Meeting[] results = MeetingMerge.merge(meetings);
    assert results[0].equals(new Meeting(1, 10));
  }
}
