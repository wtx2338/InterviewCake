package meeting_merge;

/**
 * Created by swu on 14/02/2017.
 */
public class Meeting {

  int startTime;
  int endTime;

  public Meeting(int startTime, int endTime) {
    // number of 30 min blocks past 9:00 am
    this.startTime = startTime;
    this.endTime   = endTime;
  }

  public String toString() {
    return String.format("(%d, %d)", startTime, endTime);
  }

  @Override
  public boolean equals(Object m) {
    if (! (m instanceof Meeting)) return false;
    Meeting meeting = (Meeting) m;
    return meeting.startTime == this.startTime && meeting.endTime == this.endTime;
  }
}
