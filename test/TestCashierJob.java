import junit.framework.TestCase;
import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by swu on 15/02/2017.
 */
public class TestCashierJob extends TestCase {
  @Test
  public void testNormalCase() {
    int[] inputs = {1, 2, 3};
    LinkedList solutions = CashierJob.solution(inputs, 4);

    for (Object elm : solutions) {
      System.out.println(elm);
    }
  }

  @Test
  public void testNoWay() {
    int[] inputs = {3, 5, 8};
    LinkedList solutions = CashierJob.solution(inputs, 1);

    assert solutions.size() == 0;
  }

  @Test
  public void testNoWay2() {
    int[] inputs = {17, 18, 24};
    LinkedList solutions = CashierJob.solution(inputs, 67);

    assert solutions.size() == 0;
  }
}
